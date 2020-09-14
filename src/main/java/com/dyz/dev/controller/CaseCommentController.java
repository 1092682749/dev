package com.dyz.dev.controller;

import com.alibaba.fastjson.JSON;
import com.dyz.dev.configuration.netty.NotifyService;
import com.dyz.dev.model.*;
import com.dyz.dev.service.CaseFormService;
import com.dyz.dev.service.EmployeeService;
import com.dyz.dev.service.UnreadMessageService;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.service.CaseCommentService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;

import static com.dyz.dev.utils.Constants.*;

/**
 * Created by dyz on 2020/06/19.
 */
@RestController
@RequestMapping("/case/comment")
public class CaseCommentController {
  private Logger logger = LoggerFactory.getLogger("观察帖子状态log" + CaseCommentController.class.getName());
  @Resource
  private CaseCommentService caseCommentService;

  @Resource
  private CacheUtils cacheUtils;

  @Resource
  private CaseFormService caseFormService;

  @Resource
  private NotifyService notifyService;

  @Resource
  private UnreadMessageService unreadMessageService;


  @Autowired
  private EmployeeService employeeService;

  @PostMapping("/add")
  public Result add(@RequestBody CaseComment caseComment, HttpServletRequest request) throws NoSupportCacheType {
    Employee employee = (Employee) cacheUtils.getUser(request);
    String empno = caseComment.getToEmpno();
    caseComment.setCommentEmpName(employee.getCnameSh());
    caseComment.setCommentEmpno(employee.getEmpNo());
    caseComment.setCommentTime(new Date());

    caseCommentService.save(caseComment);

    CaseForm caseForm = caseFormService.findByStringId(caseComment.getCaseId().toString());

//    String empName = caseComment.getToEmpName();
    if (empno == null || "".equals(empno)) {
      // 一级评论
      empno = caseForm.getCreateEmplid();
    } else {
      // 二级评论
      // 添加未读
      UnreadMessage unreadMessage = saveUnread(caseForm, caseComment.getCommentId(), empno, employee.getCnameSh());
      // 发送消息给被回复人
      notifyService.sendMsgToUser(empno, JSON.toJSONString(unreadMessage));

    }
    Employee toUser = employeeService.findByStringId(empno);
    caseComment.setToEmpName(toUser.getCnameSh());
    caseCommentService.update(caseComment);
    // 添加未读
    UnreadMessage unreadMessage = saveUnread(caseForm, caseComment.getCommentId(), caseForm.getCreateEmplid(), employee.getCnameSh());
    // 发送即时消息 给帖子创建人
    notifyService.sendMsgToUser(caseForm.getCreateEmplid(), JSON.toJSONString(unreadMessage));
    logger.info(employee.getEmpNo() + "评论了" + caseForm.getCreateEmplid());
    return ResultGenerator.successResult();
  }
  public UnreadMessage saveUnread(CaseForm caseForm, Integer commentId, String toEmpno, String fromName) {
    UnreadMessage unreadMessage = new UnreadMessage();
    unreadMessage.setCaseId(caseForm.getCaseId());
    unreadMessage.setCaseTitle(caseForm.getTitle());

    unreadMessage.setToEmpno(toEmpno);
    unreadMessage.setCommentId(commentId);
    unreadMessage.setCaseId(caseForm.getCaseId());
//    Employee fromUser = employeeService.findByStringId(empno);
    unreadMessage.setFromName(fromName);
    unreadMessageService.save(unreadMessage);
    return unreadMessage;
  }
  @PostMapping("/delete")
  @Transactional
  public Result delete(@RequestBody CaseComment caseComment) {
    // TODO 删除comment 需要判断删除的是否为采纳的
    Boolean isAccept = false;
    caseComment = caseCommentService.findByStringId(caseComment.getCommentId().toString());
    caseComment.setIsDelete("Y");
    if ("Y".equals(caseComment.getAccept())) {
      isAccept = true;
    }

    tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(CaseComment.class);
    // 查出下面的子comment
    condition.createCriteria().andCondition("parent_id = ", caseComment.getCommentId());
    List<CaseComment> caseCommentList = caseCommentService.findByCondition(condition);
    for (CaseComment subComment: caseCommentList) {
      if ("Y".equals(subComment.getAccept())) {
        isAccept = true;
      }
      subComment.setIsDelete("Y");
      caseCommentService.update(subComment);
    }
    //
    logger.info("delete comment: " + caseComment.getCommentId());
    caseCommentService.update(caseComment);

    // 如果为采纳答案 则需要将本贴置为未采纳 todo comment 改程blob
    if (isAccept) {
      CaseForm caseForm = caseFormService.findByStringId(caseComment.getCaseId().toString());
      caseForm.setStatus("published");
      caseFormService.update(caseForm);
    }
    return ResultGenerator.successResult();
  }

  @PostMapping("/update")
  public Result update(@RequestBody CaseComment caseComment) {
    caseCommentService.update(caseComment);
    return ResultGenerator.successResult();
  }

  @GetMapping("/detail")
  public Result detail(@RequestParam Object id) {
    CaseComment caseComment = null;
    if (id instanceof String) {
      caseComment = caseCommentService.findByStringId((String) id);
    } else {
      caseComment = caseCommentService.findById((Integer) id);
    }

    return ResultGenerator.successResult(caseComment);
  }

  @GetMapping("/list")
  public Result list(CaseComment caseComment, HttpServletRequest request) throws NoSupportCacheType {
    Employee employee = (Employee) cacheUtils.getUser(request);
    List<CaseComment> list = caseCommentService.findComments(employee.getEmpNo(), caseComment.getCaseId());

    return ResultGenerator.successResult(list);
  }

  @RequestMapping("/Rating")
  public Result Rating(@RequestBody CaseComment caseComment) {
    Integer commentId = caseComment.getCommentId();
    CaseComment caseCommentDB = caseCommentService.findByStringId(commentId.toString());
    caseCommentDB.setAdminRate(caseComment.getAdminRate());
    caseCommentService.update(caseCommentDB);
//    notifyService.sendMsgToUser(caseCommentDB.getToEmpno());
    return ResultGenerator.successResult(caseCommentDB);
  }

  @GetMapping("/rate/chart")
  public Result aggregateEmpRate(CaseComment caseComment, HttpServletRequest request) throws NoSupportCacheType {
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    if (moduleName == null) moduleName = "";
    List<RateChart> list = caseCommentService.aggregateEmpRate(moduleName);
    return ResultGenerator.successResult(list);
  }
}
