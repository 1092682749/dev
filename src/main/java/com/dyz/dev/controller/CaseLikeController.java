package com.dyz.dev.controller;
import com.dyz.dev.model.CaseForm;
import com.dyz.dev.model.Employee;
import com.dyz.dev.service.CaseFormService;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.CaseLike;
import com.dyz.dev.service.CaseLikeService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* Created by dyz on 2020/06/19.
*/
@RestController
@RequestMapping("/case/like")
public class CaseLikeController {
    @Resource
    private CaseLikeService caseLikeService;

    @Resource
    private CaseFormService caseFormService;

    @Resource
    private CacheUtils cacheUtils;

    @PostMapping("/add")
    public Result add(@RequestBody CaseLike caseLike) {
        caseLikeService.save(caseLike);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        caseLikeService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CaseLike caseLike) {
        caseLikeService.update(caseLike);
        return ResultGenerator.successResult();
    }

	@GetMapping("/detail")
	public Result detail(@RequestParam Object id) {
	    	 CaseLike caseLike  = null;
	    	if (id instanceof String) {
	    		caseLike = caseLikeService.findByStringId((String)id);
	    	}
	    	else {
	    		caseLike = caseLikeService.findById((Integer)id);
	    	}

	        return ResultGenerator.successResult(caseLike);
	 }

    @GetMapping("/list")
    public Result list(PageBean<CaseLike> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<CaseLike> list = caseLikeService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }


    @RequestMapping("/likeOrUnlike")
  public Result likeOrUnlike(@RequestBody CaseLike caseLike, HttpServletRequest request) throws NoSupportCacheType {
      Employee user = (Employee) cacheUtils.getUser(request);
      caseLike.setActionEmpno(user.getEmpNo());
      caseLike.setActionTime(new Date());

      String res = caseLikeService.likeOrUnlike(caseLike);
      // 返回不同的信息
      CaseForm caseForm = new CaseForm();
      if (caseLike.getCaseId() != null && !"".equals(caseLike.getCaseId())) {
        caseForm = caseFormService.findInfoById(user.getEmpNo(), caseLike.getCaseId());
      }
//      CaseForm caseForm = caseFormService.findInfoById(user.getEmpNo(), caseLike.getCaseId());
      return ResultGenerator.successResult(caseForm);
    }
}
