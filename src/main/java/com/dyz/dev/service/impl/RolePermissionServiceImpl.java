package com.dyz.dev.service.impl;

import com.dyz.dev.dao.RolePermissionMapper;
import com.dyz.dev.model.RolePermission;
import com.dyz.dev.service.RolePermissionService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/06/16.
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {
    @Resource
    private RolePermissionMapper solveCenterRolePermissionMapper;

}
