package com.dyz.dev.service.impl;

import com.dyz.dev.dao.RoleMapper;
import com.dyz.dev.dao.RolePermissionMapper;
import com.dyz.dev.model.Employee;
import com.dyz.dev.model.Role;
import com.dyz.dev.model.RolePermission;
import com.dyz.dev.service.RolePermissionService;
import com.dyz.dev.service.RoleService;
import com.dyz.dev.utils.AbstractService;
import com.dyz.dev.utils.ServiceException;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.dyz.dev.utils.Constants.CODE_ERR_RNAME_NULL;


/**
 * Created by dyz on 2020/06/16.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper solveCenterTblRoleMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Resource
    private RolePermissionService rolePermissionService;


    @Autowired
    private CacheUtils cacheUtils;

  @Override
  public void updateRolePermissions(Role role, HttpServletRequest request) throws NoSupportCacheType {
    if (role != null && role.getPermissions() != null){
      if (role.getId().isEmpty()){
        throw new ServiceException(CODE_ERR_RNAME_NULL);
      }
      if (role.getrName().isEmpty()){
        throw new ServiceException(CODE_ERR_RNAME_NULL);
      }
      rolePermissionMapper.safeDeleteByRid(role.getId());
      String token = cacheUtils.getToken(request);
      Employee employee = (Employee)cacheUtils.get(token,request);
      role.getPermissions().stream().distinct().forEach(permission -> {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setpId(permission.getId());
        rolePermission.setrId(role.getId());
        rolePermission.setCreateTime(new Date());
        rolePermission.setrName(role.getrName());
        rolePermission.setUpdaeNt(employee.getMailName());
        rolePermissionMapper.insertSelective(rolePermission);
      });
    }
  }
}
