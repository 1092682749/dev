package com.dyz.dev.service;
import com.dyz.dev.model.DeptOrganization;
import com.dyz.dev.utils.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by dyz on 2019/12/30.
 */
public interface DeptOrganizationService extends Service<DeptOrganization> {
    public List<Map<String, Object>> findSECT();
}
