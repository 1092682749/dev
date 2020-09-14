package com.dyz.dev.controller;

import com.dyz.dev.model.CaseForm;
import com.dyz.dev.model.Employee;
import com.dyz.dev.service.CaseFormService;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.CaseCollect;
import com.dyz.dev.service.CaseCollectService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

import static com.dyz.dev.utils.Constants.MODULE_NAME;
import static java.util.stream.Collectors.toList;

/**
 * Created by dyz on 2020/07/16.
 */
@RestController
@RequestMapping("/case/collect")
public class CaseCollectController {
  @Resource
  private CaseCollectService caseCollectService;

  @Autowired
  private CacheUtils cacheUtils;

  @Autowired
  private CaseFormService caseFormService;

  @PostMapping("/add")
  public Result add(@RequestBody CaseCollect caseCollect) {
    caseCollectService.save(caseCollect);
    return ResultGenerator.successResult();
  }

  @PostMapping("/delete")
  public Result delete(@RequestBody Integer id) {
    caseCollectService.deleteById(id);
    return ResultGenerator.successResult();
  }

  @PostMapping("/update")
  public Result update(@RequestBody CaseCollect caseCollect) {
    caseCollectService.update(caseCollect);
    return ResultGenerator.successResult();
  }

  @GetMapping("/detail")
  public Result detail(@RequestParam Object id) {
    CaseCollect caseCollect = null;
    if (id instanceof String) {
      caseCollect = caseCollectService.findByStringId((String) id);
    } else {
      caseCollect = caseCollectService.findById((Integer) id);
    }

    return ResultGenerator.successResult(caseCollect);
  }

  @GetMapping("/list")
  public Result list(PageBean<CaseForm> page, HttpServletRequest request) throws NoSupportCacheType {
    Employee user = (Employee) cacheUtils.getUser(request);
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(CaseCollect.class);
    condition.createCriteria().andCondition("empno = ", user.getEmpNo());
    List<CaseCollect> list = caseCollectService.findByCondition(condition);
    List<Integer> ids = list.stream()
      .map(CaseCollect::getCaseId).distinct()
      .collect(toList());
    PageHelper.startPage(page.getPageNum(), page.getSize());
    List<CaseForm> caseFormList = caseFormService.findByIds(user.getEmpNo(), moduleName, ids);
    page.setList(caseFormList);
    return ResultGenerator.successResult(page);
  }

  @RequestMapping("/collectCase")
  public Result collectCase( CaseCollect caseCollect, HttpServletRequest request) throws NoSupportCacheType {
    Integer id = caseCollect.getCaseId();

    Employee employee = (Employee) cacheUtils.getUser(request);

    caseCollect.setEmpno(employee.getEmpNo());
    caseCollect.setCollectTime(new Date());
    tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(CaseCollect.class);
    condition.createCriteria().andCondition("CASE_ID = ", caseCollect.getCaseId())
      .andCondition("empno = ", caseCollect.getEmpno());
    List<CaseCollect> caseCollects = caseCollectService.findByCondition(condition);
    if (caseCollects.size() > 0) {
      return ResultGenerator.errResult(1, "已经存在了");
    }
    caseCollectService.save(caseCollect);
    return ResultGenerator.successResult();
  }
}
