package com.dyz.dev.service.impl;

import com.dyz.dev.dao.IMMFileMapper;
import com.dyz.dev.model.IMMFile;
import com.dyz.dev.model.Supplier;
import com.dyz.dev.service.IMMFileService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;


/**
 * Created by dyz on 2019/12/23.
 */
@Service
@Transactional
public class IMMFileServiceImpl extends AbstractService<IMMFile> implements IMMFileService {
    @Resource
    private IMMFileMapper immTblFileMapper;

    @Override
    public String saveFile(File file, String formNo) {
        IMMFile immFile = new IMMFile();
        return null;
    }

    @Override
    public String updateIMMFileFormNo(String oldFormNo, String newFormNo) {
        Condition condition = new Condition(IMMFile.class);
        condition.createCriteria().andCondition("form_no = '" + oldFormNo + "'");
        List<IMMFile> immFileList = findByCondition(condition);
        immFileList.forEach(immFile -> {
            immFile.setFormNo(newFormNo);
            immFile.setFormType(newFormNo.split("-")[0]);
            update(immFile);
        });
        return "success";
    }
}
