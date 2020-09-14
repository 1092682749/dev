package com.dyz.dev.service.impl;

import com.dyz.dev.dao.CaseLikeMapper;
import com.dyz.dev.model.CaseLike;
import com.dyz.dev.service.CaseLikeService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;
//import java.util.concurrent.locks.Condition;


/**
 * Created by dyz on 2020/06/19.
 */
@Service
@Transactional
public class CaseLikeServiceImpl extends AbstractService<CaseLike> implements CaseLikeService {
  @Resource
  private CaseLikeMapper solveCenterTblLikeMapper;

  @Override
  public String likeOrUnlike(CaseLike caseLike) {
    Condition condition = new Condition(CaseLike.class);
    if (caseLike.getCaseId() != null && !"".equals(caseLike.getCaseId())) {
      condition.createCriteria()
        .andCondition("CASE_ID = ", caseLike.getCaseId())
        .andCondition("ACTION_EMPNO =  ", caseLike.getActionEmpno());
      caseLike.setTargetType("case");
    } else if (caseLike.getCommentId() != null && !"".equals(caseLike.getCommentId())){
      condition.createCriteria()
        .andCondition("comment_id = ", caseLike.getCommentId())
        .andCondition("ACTION_EMPNO =  ", caseLike.getActionEmpno());
      caseLike.setTargetType("comment");
    } else {
      return "缺少like or unlike目标信息";
    }

    List<CaseLike> caseLikes = findByCondition(condition);
//    if (caseLike == null)
    if (caseLikes.size() == 0) {
      save(caseLike);
    } else {
      CaseLike oldLike = caseLikes.get(0);
      caseLike.setActionId(oldLike.getActionId());
      Boolean already = caseLike.getAction().equals(oldLike.getAction());
      if (already) {
        caseLike.setAction("cancel " + caseLike.getAction());
        update(caseLike);
        return "已经取消" + mappingAction(caseLike.getAction());
      }

      update(caseLike);
    }
    return mappingAction(caseLike.getAction()) + "成功!";
  }

  public String mappingAction(String action) {
    if ("like".equals(action)) return "认同";
    return "不认同";
  }
}
