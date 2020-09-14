package com.dyz.dev.controller;
import com.dyz.dev.model.Employee;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.Tag;
import com.dyz.dev.service.TagService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.dyz.dev.utils.Constants.MODULE_NAME;

/**
* Created by dyz on 2020/06/29.
*/
@RestController
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;

  @Autowired
  CacheUtils cacheUtils;

    @PostMapping("/add")
    public Result add(@RequestBody Tag tag, HttpServletRequest request) throws NoSupportCacheType {
        Employee employee = (Employee) cacheUtils.getUser(request);
        tag.setCreateEmpno(employee.getEmpNo());
        String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
        tag.setRoleName(moduleName);
        tagService.save(tag);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        tagService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Tag tag, HttpServletRequest request) throws NoSupportCacheType {
      Employee employee = (Employee) cacheUtils.getUser(request);
      tag.setCreateEmpno(employee.getEmpNo());
      String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
      tag.setRoleName(moduleName);
        tagService.update(tag);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 Tag tag  = null;
	    	if (id instanceof String) {
	    		tag = tagService.findByStringId((String)id);
	    	}
	    	else {
	    		tag = tagService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(tag);
	 }

    @GetMapping("/list")
    public Result list(HttpServletRequest request) throws NoSupportCacheType {
//        PageHelper.startPage(page.getPageNum(),page.getSize());
//        List<Tag> list = tagService.findAll();
      String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
      List<Tag> list = tagService.findAllByModuleName(moduleName);
//        page.setList(list);
        return ResultGenerator.successResult(list);
    }

  @GetMapping("/page/list")
  public Result pageList(PageBean<Tag> page, HttpServletRequest request) throws NoSupportCacheType {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
        List<Tag> list = tagService.findAllByModuleName(moduleName);
        page.setList(list);
    return ResultGenerator.successResult(page);
  }
}
