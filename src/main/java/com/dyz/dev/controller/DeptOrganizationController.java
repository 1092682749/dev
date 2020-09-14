package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.DeptOrganization;
import com.dyz.dev.service.DeptOrganizationService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by dyz on 2019/12/30.
*/
@RestController
@RequestMapping("/organization")
public class DeptOrganizationController {
    @Resource
    private DeptOrganizationService deptOrganizationService;

    @PostMapping("/add")
    public Result add(@RequestBody DeptOrganization deptOrganization) {
        deptOrganizationService.save(deptOrganization);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        deptOrganizationService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DeptOrganization deptOrganization) {
        deptOrganizationService.update(deptOrganization);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 DeptOrganization deptOrganization  = null;
	    	if (id instanceof String) {
	    		deptOrganization = deptOrganizationService.findByStringId((String)id);
	    	}
	    	else {
	    		deptOrganization = deptOrganizationService.findById((Integer)id);
	    	}
	        
	        return ResultGenerator.successResult(deptOrganization);
	 }

    @GetMapping("/list")
    public Result list(PageBean<DeptOrganization> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<DeptOrganization> list = deptOrganizationService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/getSect")
    public Result getDeptTree() {
        List<Map<String, Object>> deptOrganizations = deptOrganizationService.findSECT();
        return ResultGenerator.successResult(deptOrganizations);
    }
}
