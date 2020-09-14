package com.dyz.dev.service;
import com.dyz.dev.model.Role;
import com.dyz.dev.utils.Service;
import com.dyz.dev.utils.cache.NoSupportCacheType;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by dyz on 2020/06/16.
 */
public interface RoleService extends Service<Role> {
  void updateRolePermissions(Role role, HttpServletRequest request) throws NoSupportCacheType;
}
