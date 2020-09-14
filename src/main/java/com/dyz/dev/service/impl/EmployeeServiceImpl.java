package com.dyz.dev.service.impl;

import com.dyz.dev.dao.EmployeeMapper;
import com.dyz.dev.model.Employee;
import com.dyz.dev.service.EmployeeService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dyz on 2019/12/23.
 */
@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {
    @Resource
    private EmployeeMapper chrTEmpMapper;

    @Override
    public Employee findManagerByDeptId(String deptId) {
        return chrTEmpMapper.findManagerByDeptId(deptId);
    }

    @Override
    public List<Employee> findEmpOfManager(String deptId) {
        Employee employee = findManagerByDeptId(deptId);
        Condition condition = new Condition(Employee.class);
        condition.createCriteria().andCondition("MANAGER = " + employee.getEmpNo());
        return findByCondition(condition);
        // return null;
    }
}
