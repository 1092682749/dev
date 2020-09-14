package com.dyz.dev.service;
import com.dyz.dev.model.Employee;
import com.dyz.dev.utils.Service;

import java.util.List;


/**
 * Created by dyz on 2019/12/23.
 */
public interface EmployeeService extends Service<Employee> {
    public Employee findManagerByDeptId(String deptId);
    public List<Employee> findEmpOfManager(String deptId);
}
