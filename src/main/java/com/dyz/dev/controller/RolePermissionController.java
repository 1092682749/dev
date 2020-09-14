package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.RolePermission;
import com.dyz.dev.service.RolePermissionService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2020/06/16.
*/
@RestController
@RequestMapping("/role/permission")
public class RolePermissionController {
    @Resource
    private RolePermissionService rolePermissionService;

    @PostMapping("/add")
    public Result add(@RequestBody RolePermission rolePermission) {
        rolePermissionService.save(rolePermission);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        rolePermissionService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody RolePermission rolePermission) {
        rolePermissionService.update(rolePermission);
        return ResultGenerator.successResult();
    }

  @PostMapping("/grant")
  public Result grant(@RequestBody RolePermission rolePermission) {
    rolePermissionService.update(rolePermission);
    return ResultGenerator.successResult();
  }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 RolePermission rolePermission  = null;
	    	if (id instanceof String) {
	    		rolePermission = rolePermissionService.findByStringId((String)id);
	    	}
	    	else {
	    		rolePermission = rolePermissionService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(rolePermission);
	 }

    @GetMapping("/list")
    public Result list(PageBean<RolePermission> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<RolePermission> list = rolePermissionService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
