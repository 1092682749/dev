package com.dyz.dev.service.impl;

import com.dyz.dev.dao.DeptOrganizationMapper;
import com.dyz.dev.model.DeptOrganization;
import com.dyz.dev.service.DeptOrganizationService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by dyz on 2019/12/30.
 */
@Service
@Transactional
public class DeptOrganizationServiceImpl extends AbstractService<DeptOrganization> implements DeptOrganizationService {
    @Resource
    private DeptOrganizationMapper chrTDeptOrgMapper;

    @Override
    public List<Map<String, Object>> findSECT() {
        return chrTDeptOrgMapper.findSECT();
    }
}
