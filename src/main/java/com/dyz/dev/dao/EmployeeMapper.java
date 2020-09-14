package com.dyz.dev.dao;

import com.dyz.dev.model.Employee;
import com.dyz.dev.utils.Mapper;

public interface EmployeeMapper extends Mapper<Employee> {
    public Employee findManagerByDeptId(String deptId);
}