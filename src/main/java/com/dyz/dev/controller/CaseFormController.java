package com.dyz.dev.controller;

import com.sun.tracing.dtrace.ModuleName;
import com.dyz.dev.configuration.netty.ChannelMap;
import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.Employee;
import com.dyz.dev.service.CaseCommentService;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.CaseForm;
import com.dyz.dev.service.CaseFormService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import com.dyz.dev.utils.es.ESTools;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.dyz.dev.utils.Constants.MODULE_NAME;
import static java.util.stream.Collectors.toList;

/**
 * Created by dyz on 2020/06/15.
 */
@RestController
@RequestMapping("/caseForm")
public class CaseFormController {
  @Resource
  private CaseFormService caseFormService;

  @Resource
  private CaseCommentService caseCommentService;

  @Resource
  private CacheUtils cacheUtils;

  @Autowired
  ESTools esTools;

  @PostMapping("/save")
  public Result add(@RequestBody CaseForm caseForm,
                    HttpServletRequest request) throws IOException, NoSupportCacheType, IntrospectionException, IllegalAccessException {

    Employee employee = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    // 转list
    if ("".equals(caseForm.getModuleName()) || caseForm.getModuleName() == null) {
      caseForm.setModuleName(moduleName);
    }

    caseForm.setCreateEmpl(employee.getMailName());
    caseForm.setCreateEmplid(employee.getEmpNo());

    caseFormService.saveAndUpdate(caseForm);
    String content = caseForm.getContent();
//    System.out.println(content);

    /// 多个模块同时放入
    List<String> ms = Arrays.asList(caseForm.getModuleName().split(",")).stream().filter(i -> !"".equals(i)).collect(toList());
    for (String name : ms) {
//      esTools.putDocument(name.toLowerCase(), caseForm);
    }
//    esTools.putDocument(moduleName.toLowerCase(), caseForm);
    return ResultGenerator.successResult();
  }

  @PostMapping("/delete")
  public Result delete(@RequestBody CaseForm caseForm, HttpServletRequest request) throws IntrospectionException, IllegalAccessException, NoSupportCacheType, IOException {
    CaseForm caseFormDB = caseFormService.findByStringId(caseForm.getCaseId().toString());
    caseFormDB.setIsDelete("Y");
    caseFormService.saveAndUpdate(caseFormDB);
    Employee user = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    List<String> modules = Arrays.stream(moduleName.split(",")).filter(i -> !"".equals(i)).collect(toList());
    for (String module : modules) {
      esTools.DeleteDoc(module,  caseForm.getCaseId().toString());
    }
//    esTools.DeleteDoc();
    return ResultGenerator.successResult();
  }

  @PostMapping("/update")
  public Result update(@RequestBody CaseForm caseForm) {
    caseFormService.update(caseForm);
    return ResultGenerator.successResult();
  }

  @GetMapping("/detail")
  public Result detail(@RequestParam Object id) {
    CaseForm caseForm = null;
    if (id instanceof String) {
      caseForm = caseFormService.findByStringId((String) id);
    } else {
      caseForm = caseFormService.findById((Integer) id);
    }
    if ("Y".equals(caseForm.getIsDelete())) {

      return ResultGenerator.errResult(302, "该帖子已被管理员删除禁止查看");
    }
    return ResultGenerator.successResult(caseForm);
  }

  @GetMapping("/list")
  public Result list(PageBean<CaseForm> page, HttpServletRequest request) throws NoSupportCacheType, IOException {
    List<CaseForm> caseFormList = null;
    Employee user = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    if (moduleName == null) moduleName = "";
    PageHelper.startPage(page.getPageNum(), page.getSize(), page.getOrderBy());
    if (page.getCondition() != null && !"".equals(page.getCondition())) {
      //
      List<Integer> idList = new ArrayList<>();
      List<String> ms = Arrays.asList(moduleName.split(",")).stream().filter(i -> !"".equals(i)).collect(toList());
      for (String name : ms) {
        // 多个索引查询
        idList.addAll(
          esTools.searchByBool(name, page.getCondition(), null, null)
            .stream().map(caseForm -> caseForm.getCaseId()).distinct()
            .collect(ArrayList::new, List::add, List::addAll)
        );
      }
//      idList = esTools.searchByBool("index1", page.getCondition(), null, null)
//        .stream().map(caseForm -> caseForm.getCaseId())
//        .collect(toList());
      if (idList.size() != 0) {
        caseFormList = caseFormService.findByIds(user.getEmpNo(), moduleName, idList);
      }
    } else {
      caseFormList = caseFormService.findAllCaseInfo(user.getEmpNo(), moduleName);
    }

    page.setList(caseFormList);
    return ResultGenerator.successResult(page);
  }

  @GetMapping("/searchList")
  public Result searchList(PageBean<CaseForm> page, HttpServletRequest request) throws NoSupportCacheType {

    Employee user = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    PageHelper.startPage(page.getPageNum(), page.getSize());
    List<CaseForm> list = caseFormService.findAllCaseInfo(user.getEmpNo(), moduleName);
    page.setList(list);
    return ResultGenerator.successResult(page);
  }


  @GetMapping("/sendMsgToAll")
  public void sendMsgToAll(String msg) {
    ChannelMap.channelMap.forEachValue(1, (channel) -> {
      channel.writeAndFlush(new TextWebSocketFrame(msg));
    });
  }


  @RequestMapping("/accept")
  public Result accept(@RequestBody CaseComment caseComment) {
    caseFormService.accept(caseComment);
    return ResultGenerator.successResult();
  }

  @RequestMapping("/findMyCase")
  public Result findMyCase(PageBean<CaseForm> page, HttpServletRequest request) throws NoSupportCacheType {
    Employee employee = (Employee) cacheUtils.getUser(request);
//    employee.getEmpNo();
    Condition condition = new Condition(CaseForm.class);
    condition.createCriteria()
      .andCondition("CREATE_EMPLID = ", employee.getEmpNo())
      .andCondition("nvl(IS_DELETE, 'N') != ", "Y");
    PageHelper.startPage(page.getPageNum(), page.getSize());
    List<CaseForm> caseFormList = caseFormService.findByCondition(condition);
    page.setList(caseFormList);
    return ResultGenerator.successResult(page);
  }

  @RequestMapping("/Oldest")
  public Result Oldest(PageBean<CaseForm> page, HttpServletRequest request) throws NoSupportCacheType {
    Employee employee = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    PageHelper.startPage(page.getPageNum(), page.getSize());
    List<CaseForm> caseFormList = caseFormService.Oldest(employee.getEmpNo(), moduleName);
    page.setList(caseFormList);
    return ResultGenerator.successResult(page);
  }

  @RequestMapping("/putNoSaveDoc")
  public Result putNoSaveDoc(HttpServletRequest request) throws NoSupportCacheType, IOException {
    Employee employee = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    List<CaseForm> caseFormList = esTools.findAllByIndex(moduleName);
    List<CaseForm> caseFormDB = caseFormService.findAllCaseInfo(employee.getEmpNo(), moduleName);
    List<Integer> idlist = caseFormList.stream().map(CaseForm::getCaseId).collect(toList());
    List<Integer> idlistNeed = caseFormDB.stream().map(CaseForm::getCaseId).filter(i -> !idlist.contains(i))
      .collect(toList());
    for (Integer id : idlistNeed) {
      List<String> modules = Arrays.stream(moduleName.split(",")).filter(i -> !"".equals(i)).collect(toList());
      for (String module : modules) {
        esTools.putDocument(module, caseFormService.findInfoById(employee.getEmpNo(), id));
      }
    }
    return ResultGenerator.successResult(idlistNeed);
  }

  @RequestMapping("/Rating")
  public Result Rating(@RequestBody CaseForm caseForm) {
    Integer caseId = caseForm.getCaseId();
    CaseForm caseFromDB = caseFormService.findByStringId(caseId.toString());
    caseFromDB.setAdminRate(caseForm.getAdminRate());
    caseFormService.update(caseFromDB);
    return ResultGenerator.successResult(caseFromDB);
  }
}
