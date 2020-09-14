package com.dyz.dev.controller;

import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.Employee;
import com.dyz.dev.service.EmployeeService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2019/12/23.
*/
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;



    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        employeeService.save(employee);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        employeeService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 Employee employee  = null;
	    	if (id instanceof String) {
	    		employee = employeeService.findByStringId((String)id);
	    	}
	    	else {
	    		employee = employeeService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(employee);
	 }

    @GetMapping("/list")
    public Result list(PageBean<Employee> page, @RequestParam(required = false) String account) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Employee> list = null;
        if(account != null && !account.isEmpty()){
          Condition condition = new Condition(Employee.class);
          Example.Criteria criteria = condition.createCriteria();
          criteria.andEqualTo("mailName", account.toUpperCase());
          list = employeeService.findByCondition(condition);
        }else {
          list = employeeService.findAll();
        }
        page.setList(list);
        return ResultGenerator.successResult(page);
    }



    @RequestMapping("/findEmpOfManager")
    public Result findEmpOfManager(String deptId) {
        List<Employee> employees = employeeService.findEmpOfManager(deptId);
        return ResultGenerator.successResult(employees);
    }
}
