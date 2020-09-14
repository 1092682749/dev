package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.UserRole;
import com.dyz.dev.service.UserRoleService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2020/06/16.
*/
@RestController
@RequestMapping("/user/role")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;

    @PostMapping("/add")
    public Result add(@RequestBody UserRole userRole) {
        userRoleService.save(userRole);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        userRoleService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserRole userRole) {
        userRoleService.update(userRole);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 UserRole userRole  = null;
	    	if (id instanceof String) {
	    		userRole = userRoleService.findByStringId((String)id);
	    	}
	    	else {
	    		userRole = userRoleService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(userRole);
	 }

    @GetMapping("/list")
    public Result list(PageBean<UserRole> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<UserRole> list = userRoleService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
