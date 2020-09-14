package com.dyz.dev.service.impl;

import com.dyz.dev.dao.CaseCommentMapper;
import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.RateChart;
import com.dyz.dev.service.CaseCommentService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dyz on 2020/06/19.
 */
@Service
@Transactional
public class CaseCommentServiceImpl extends AbstractService<CaseComment> implements CaseCommentService {
    @Resource
    private CaseCommentMapper solveCenterTblCommentMapper;

  @Override
  public List<CaseComment> findComments(String empno, Integer caseId) {
    return solveCenterTblCommentMapper.findComments(empno, caseId);
  }

  @Override
  public List<RateChart> aggregateEmpRate(String moduleName) {
    return solveCenterTblCommentMapper.aggregateEmpRate("%" + moduleName + "%");
  }


}
