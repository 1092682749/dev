package com.dyz.dev.controller;
import com.dyz.dev.model.Role;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.Permission;
import com.dyz.dev.service.PermissionService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.ServiceException;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.dyz.dev.utils.Constants.CODE_ERR_PNAME_EXIST;

/**
* Created by dyz on 2020/06/16.
*/
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @PostMapping("/add")
    public Result add(@RequestBody Permission permission) {
      Permission tp = permissionService.findBy("pName",permission.getpName());
      if (tp != null){
        throw new ServiceException(CODE_ERR_PNAME_EXIST);
      }
        permissionService.save(permission);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        permissionService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Permission permission) {
        permissionService.update(permission);
        return ResultGenerator.successResult();
    }


	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 Permission permission  = null;
	    	if (id instanceof String) {
	    		permission = permissionService.findByStringId((String)id);
	    	}
	    	else {
	    		permission = permissionService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(permission);
	 }

    @GetMapping("/list")
    public Result list(PageBean<Permission> page,@RequestParam(required = false) String roleName) {
      PageHelper.startPage(page.getPageNum(),page.getSize());
      List<Permission> list = new ArrayList<Permission>();
      if(roleName != null && !roleName.isEmpty()){
        list = permissionService.getPermissionsByRoleName(roleName);
      }else {
        list = permissionService.findAll();
      }
      page.setList(list);
      return ResultGenerator.successResult(page);
    }

  @GetMapping("/list/{id}")
  public Result list(@PathVariable(value = "id") String id) {
    Role role = permissionService.getRolePermissions(id);
    return ResultGenerator.successResult(role);
  }
}
