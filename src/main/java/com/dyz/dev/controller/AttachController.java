package com.dyz.dev.controller;
import com.dyz.dev.service.AttachService;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.model.Attach;
import com.dyz.dev.utils.PageBean;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2019/08/14.
*/
@RestController
@RequestMapping("/attach")
public class AttachController {
    @Resource
    private AttachService attachService;

    @PostMapping("/add")
    public Result add(@RequestBody Attach attach) {
        attachService.save(attach);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        attachService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Attach attach) {
        attachService.update(attach);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Object id) {
    	Attach attach = null;
    	if (id instanceof String) {
    		attach = attachService.findByStringId((String)id);
    	}
    	else {
    		attach = attachService.findById((Integer)id);
    	}
        
        return ResultGenerator.successResult(attach);
    }
    
  
    

    @GetMapping("/list")
    public Result list(PageBean<Attach> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Attach> list = attachService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
