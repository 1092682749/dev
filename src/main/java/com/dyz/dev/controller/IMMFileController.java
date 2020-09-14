package com.dyz.dev.controller;

import com.dyz.dev.model.FileBean;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.IMMFile;
import com.dyz.dev.service.IMMFileService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.upload.Base64UploadEntity;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by dyz on 2019/12/23.
 */
@RestController
@RequestMapping("/file")
public class IMMFileController {
    public static Logger logger = Logger.getLogger(IMMFileController.class.getName());
    @Resource
    private IMMFileService iMMFileService;

//    @Value("${file.save.path}")

    @Value("${file.save.path}")
    private String savePath;

    @PostMapping("/add")
    public Result add(@RequestBody IMMFile iMMFile) {
        iMMFileService.save(iMMFile);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        iMMFileService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody IMMFile iMMFile) {
        iMMFileService.update(iMMFile);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Object id) {
        IMMFile iMMFile = null;
        if (id instanceof String) {
            iMMFile = iMMFileService.findByStringId((String) id);
        } else {
            iMMFile = iMMFileService.findById((Integer) id);
        }

        return ResultGenerator.successResult(iMMFile);
    }

    @GetMapping("/list")
    public Result list(PageBean<IMMFile> page) {
        PageHelper.startPage(page.getPageNum(), page.getSize());
        List<IMMFile> list = iMMFileService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }

    @RequestMapping("/uploadFileAndDescription")
    public Result uploadFileAndDescription(
            MultipartFile file,
            String formNo,
            String classify,
            String description) {
        File path = new File(savePath);
//        if (path.)//
        if (!path.exists()) {
            path.mkdirs();
        }
        IMMFile immFile = new IMMFile();
        immFile.setDeleted("N");
        immFile.setDescription(description);
        immFile.setFormNo(formNo);
        immFile.setFileClassify(classify);
        immFile.setFormType(formNo.split("-")[0]);
        immFile.setFileFid(new Date().getTime() + "");
        try {

            if (file != null) {
                String fid = new Date().getTime() + "_" + file.getOriginalFilename();
                File distFile = new File(savePath + fid);
                file.transferTo(distFile);
                immFile.setFileFid(fid);
                immFile.setFileName(file.getOriginalFilename());
                immFile.setFilePath(distFile.getAbsolutePath());

            }
            // iMMFileService.saveFile(distFile, fileBean.getFormNo());
        } catch (IOException e) {
            e.printStackTrace();
//            throw new IOException("文件上传失败");
            return ResultGenerator.errResult(500, "文件上传失败");
        }
        iMMFileService.save(immFile);
        return ResultGenerator.successResult(immFile);
    }

    /**
     * @param fileBean
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadFile", produces = {"text/html;chartset=UTF-8", "application/json;charset=UTF-8"})
    public Result uploadFile(FileBean fileBean) throws IOException {
        System.out.println(fileBean.getFile().isEmpty());
        MultipartFile file = fileBean.getFile();
        File path = new File(savePath);
//        if (path.)//
        if (!path.exists()) {
            path.mkdirs();
        }
        String fid = new Date().getTime() + "_" + file.getOriginalFilename();
        File distFile = new File(savePath + fid);
        // distFile.createNewFile();
        IMMFile immFile = new IMMFile();
        try {
            file.transferTo(distFile);
            immFile.setFileClassify(fileBean.getClassify());
            immFile.setFormType(fileBean.getFormNo().split("-")[0]);
            immFile.setFileFid(fid);
            immFile.setFileName(file.getOriginalFilename());
            immFile.setFormNo(fileBean.getFormNo());
            immFile.setFilePath(distFile.getAbsolutePath());
            immFile.setDeleted("N");
            // iMMFileService.saveFile(distFile, fileBean.getFormNo());
        } catch (IOException e) {
            e.printStackTrace();
//            throw new IOException("文件上传失败");
            return ResultGenerator.errResult(500, "文件上传失败");
        }
        logger.info("upload =============================== " + immFile.getFileName());
        iMMFileService.save(immFile);
        return ResultGenerator.successResult(immFile);
    }

    /**
     * @param fid
     * @return
     * @throws Exception
     */
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fid) throws Exception {

        ResponseEntity<byte[]> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        IMMFile immFile = iMMFileService.findByStringId(fid);
        if (immFile == null) {
            return new ResponseEntity<byte[]>("没有对应file可能已经删除或移动，请联系管理员".getBytes(), HttpStatus.ACCEPTED);
        }

        File file = new File(savePath + fid);
        if (!file.exists()) {
            return new ResponseEntity<byte[]>("没有对应file可能已经删除或移动，请联系管理员".getBytes(), HttpStatus.ACCEPTED);
        }
        // 获取该文档实际的名称
        String fileOrgName = immFile.getFileName();
        // 解决中文乱码
        String downloadFileName = new String(fileOrgName.getBytes("UTF-8"), "iso-8859-1");
        // 设置响应头
        headers.setContentDispositionFormData("attachment", downloadFileName);
        InputStream in = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = in.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        responseEntity = new ResponseEntity<byte[]>(bos.toByteArray(), headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping("/deleteFile")
    public Result deleteFile(String fid) {
        IMMFile file = iMMFileService.findByStringId(fid);
        file.setDeleted("Y");
        iMMFileService.update(file);
        return ResultGenerator.successResult();
    }

    @RequestMapping("/uploadFileByBase64")
    public Result uploadFileByBase64(@RequestBody Base64UploadEntity fileEntity) throws IOException {
      String base64Str = fileEntity.getBaseStr();
      File saveFilePath = new File(savePath);
      if (!saveFilePath.exists()) {
        saveFilePath.mkdirs();
      }
      String fid = new Date().getTime() + "_" + fileEntity.getFileName();
      File file = new File(savePath + fid);
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fos = new FileOutputStream(file);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      String[] strs = base64Str.split(";");
      BASE64Decoder decoder = new BASE64Decoder();
      byte[] b = decoder.decodeBuffer(base64Str.split(",")[1]);
      fos.write(b);
      bos.flush();
      bos.close();

//      Path path = Files.write(Paths.get(savePath + fid), Base64.getMimeDecoder().decode(base64Str), StandardOpenOption.CREATE);
      IMMFile i = new IMMFile();
      i.setFileFid(fid);
      i.setFilePath(savePath+fid);
      i.setFileName(fileEntity.getFileName());
      iMMFileService.save(i);

      return ResultGenerator.successResult(i);
    }


    @RequestMapping("/getFileList")
    public Result getFileList(@RequestParam(name = "formNo") String formNo,
                              @RequestParam(name = "classify") String classify) {
        Condition condition = new Condition(IMMFile.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("form_no = '" + formNo + "'")
                .andCondition("file_classify = '" + classify + "'")
                .andCondition("deleted = 'N'");

        List<IMMFile> immFiles = iMMFileService.findByCondition(condition);
        return ResultGenerator.successResult(immFiles);
    }
}
