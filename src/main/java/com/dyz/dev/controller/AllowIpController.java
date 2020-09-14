package com.dyz.dev.controller;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.AllowIp;
import com.dyz.dev.service.AllowIpService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2020/07/20.
*/
@RestController
@RequestMapping("/allow/ip")
public class AllowIpController {
    @Resource
    private AllowIpService allowIpService;

    @PostMapping("/add")
    public Result add(@RequestBody AllowIp allowIp) {
        allowIpService.save(allowIp);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        allowIpService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AllowIp allowIp) {
        allowIpService.update(allowIp);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 AllowIp allowIp  = null;
	    	if (id instanceof String) {
	    		allowIp = allowIpService.findByStringId((String)id);
	    	}
	    	else {
	    		allowIp = allowIpService.findById((Integer)id);
	    	}
	        
	        return ResultGenerator.successResult(allowIp);
	 }

    @GetMapping("/list")
    public Result list(PageBean<AllowIp> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<AllowIp> list = allowIpService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
