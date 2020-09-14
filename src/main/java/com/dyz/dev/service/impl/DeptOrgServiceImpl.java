package com.dyz.dev.service.impl;

import com.dyz.dev.dao.DeptOrgMapper;
import com.dyz.dev.model.DeptOrg;
import com.dyz.dev.service.DeptOrgService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/08/12.
 */
@Service
@Transactional
public class DeptOrgServiceImpl extends AbstractService<DeptOrg> implements DeptOrgService {
    @Resource
    private DeptOrgMapper chrTDeptOrgMapper;

}
