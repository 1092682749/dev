package com.dyz.dev.dao;

import com.dyz.dev.model.RolePermission;
import com.dyz.dev.utils.Mapper;

import java.util.List;

public interface RolePermissionMapper extends Mapper<RolePermission> {
  List<RolePermission> findRolePermissionByRidAndPid(String rId, String pId);
  Integer safeDeleteByRid(String rId);
}
