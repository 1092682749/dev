package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.Role;
import com.dyz.dev.service.RoleService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by dyz on 2020/06/16.
*/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("/add")
    public Result add(@RequestBody Role role) {
        roleService.save(role);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        roleService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Role role) {
        roleService.update(role);
        return ResultGenerator.successResult();
    }

    @PostMapping("/grant")
    public Result grant(@RequestBody Role role, HttpServletRequest request) throws NoSupportCacheType {
      if (role != null && role.getPermissions() != null){
        roleService.updateRolePermissions(role, request);
      }
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 Role role  = null;
	    	if (id instanceof String) {
	    		role = roleService.findByStringId((String)id);
	    	}
	    	else {
	    		role = roleService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(role);
	 }

    @GetMapping("/list")
    public Result list(PageBean<Role> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
      Condition condition = new Condition(Role.class);
      Example.Criteria criteria = condition.createCriteria();
      criteria.andEqualTo("isDelete", "N");
      List<Role> list = roleService.findByCondition(condition);
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
