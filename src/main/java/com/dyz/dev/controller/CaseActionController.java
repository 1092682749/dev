package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.CaseAction;
import com.dyz.dev.service.CaseActionService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2020/06/15.
*/
@RestController
@RequestMapping("/case/action")
public class CaseActionController {
    @Resource
    private CaseActionService caseActionService;

    @PostMapping("/add")
    public Result add(@RequestBody CaseAction caseAction) {
        caseActionService.save(caseAction);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        caseActionService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CaseAction caseAction) {
        caseActionService.update(caseAction);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 CaseAction caseAction  = null;
	    	if (id instanceof String) {
	    		caseAction = caseActionService.findByStringId((String)id);
	    	}
	    	else {
	    		caseAction = caseActionService.findById((Integer)id);
	    	}
	        
	        return ResultGenerator.successResult(caseAction);
	 }

    @GetMapping("/list")
    public Result list(PageBean<CaseAction> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<CaseAction> list = caseActionService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
