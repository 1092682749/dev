package com.dyz.dev.service.impl;

import com.dyz.dev.dao.PermissionMapper;
import com.dyz.dev.dao.RoleMapper;
import com.dyz.dev.model.Permission;
import com.dyz.dev.model.Role;
import com.dyz.dev.service.PermissionService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dyz on 2020/06/16.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper solveCenterTblPermissionMapper;

    @Resource
    private RoleMapper roleMapper;

  @Override
  public Role getRolePermissions(String roleName) {
    return roleMapper.getRolePermissions(roleName);
  }

  @Override
  public List<Permission> getPermissionsByRoleName(String roleName) {
    return solveCenterTblPermissionMapper.getPermissionsByRoleName(roleName);
  }
}
