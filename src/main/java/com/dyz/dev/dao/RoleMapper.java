package com.dyz.dev.dao;

import com.dyz.dev.model.Role;
import com.dyz.dev.utils.Mapper;

public interface RoleMapper extends Mapper<Role> {
  Role getRolePermissions(String roleName);
}
