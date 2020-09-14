package com.dyz.dev.dao;

import com.dyz.dev.model.DeptOrganization;
import com.dyz.dev.utils.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptOrganizationMapper extends Mapper<DeptOrganization> {
    public List<Map<String, Object>> findSECT();
}