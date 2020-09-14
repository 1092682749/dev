package com.dyz.dev.controller;

import com.dyz.dev.model.Employee;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.UnreadMessage;
import com.dyz.dev.service.UnreadMessageService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.dyz.dev.utils.Constants.MODULE_NAME;

/**
 * Created by dyz on 2020/07/15.
 */
@RestController
@RequestMapping("/unread/message")
public class UnreadMessageController {
  @Resource
  private UnreadMessageService unreadMessageService;
  @Autowired
  private CacheUtils cacheUtils;

  @PostMapping("/add")
  public Result add(@RequestBody UnreadMessage unreadMessage) {
    unreadMessageService.save(unreadMessage);
    return ResultGenerator.successResult();
  }

  @PostMapping("/delete")
  public Result delete(@RequestBody String id) {
    unreadMessageService.deleteByStringId(id); // ;Id(id);
    return ResultGenerator.successResult();
  }

  @PostMapping("/update")
  public Result update(@RequestBody UnreadMessage unreadMessage) {
    unreadMessageService.update(unreadMessage);
    return ResultGenerator.successResult();
  }

  @GetMapping("/detail")
  public Result detail(@RequestParam Object id) {
    UnreadMessage unreadMessage = null;
    if (id instanceof String) {
      unreadMessage = unreadMessageService.findByStringId((String) id);
    } else {
      unreadMessage = unreadMessageService.findById((Integer) id);
    }

    return ResultGenerator.successResult(unreadMessage);
  }

  @GetMapping("/list")
  public Result list(PageBean<UnreadMessage> page, HttpServletRequest request) throws NoSupportCacheType {
    Employee employee = (Employee) cacheUtils.getUser(request);
//    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    PageHelper.startPage(page.getPageNum(), page.getSize());
    Condition condition = new Condition(UnreadMessage.class);
    condition.createCriteria().andCondition("TO_EMPNO = ", employee.getEmpNo());
    List<UnreadMessage> list = unreadMessageService.findByCondition(condition);
//    List<UnreadMessage> list = unreadMessageService.findAll();
//    page.setList(list);
    return ResultGenerator.successResult(list);
  }

//    @RequestBody('')
}
