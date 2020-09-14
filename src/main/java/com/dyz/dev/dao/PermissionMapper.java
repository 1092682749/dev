package com.dyz.dev.dao;

import com.dyz.dev.model.Permission;
import com.dyz.dev.utils.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
  List<Permission> getPermissionsByRoleName(String roleName);
}
