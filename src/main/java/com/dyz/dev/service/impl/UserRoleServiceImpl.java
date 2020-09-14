package com.dyz.dev.service.impl;

import com.dyz.dev.dao.UserRoleMapper;
import com.dyz.dev.model.UserRole;
import com.dyz.dev.service.UserRoleService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2020/06/16.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper solveCenterUserRoleMapper;

}
