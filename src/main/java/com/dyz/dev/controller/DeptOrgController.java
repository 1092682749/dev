package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.DeptOrg;
import com.dyz.dev.service.DeptOrgService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2020/08/12.
*/
@RestController
@RequestMapping("/dept/org")
public class DeptOrgController {
    @Resource
    private DeptOrgService deptOrgService;

    @PostMapping("/add")
    public Result add(@RequestBody DeptOrg deptOrg) {
        deptOrgService.save(deptOrg);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        deptOrgService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DeptOrg deptOrg) {
        deptOrgService.update(deptOrg);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 DeptOrg deptOrg  = null;
	    	if (id instanceof String) {
	    		deptOrg = deptOrgService.findByStringId((String)id);
	    	}
	    	else {
	    		deptOrg = deptOrgService.findById((Integer)id);
	    	}
	        
	        return ResultGenerator.successResult(deptOrg);
	 }

    @GetMapping("/list")
    public Result list(PageBean<DeptOrg> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<DeptOrg> list = deptOrgService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
