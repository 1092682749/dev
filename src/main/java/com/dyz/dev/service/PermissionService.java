package com.dyz.dev.service;
import com.dyz.dev.model.Permission;
import com.dyz.dev.model.Role;
import com.dyz.dev.utils.Service;

import java.util.List;


/**
 * Created by dyz on 2020/06/16.
 */
public interface PermissionService extends Service<Permission> {
  Role getRolePermissions(String roleName);
  List<Permission> getPermissionsByRoleName(String roleName);
}
