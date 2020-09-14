package com.dyz.dev.service;
import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.RateChart;
import com.dyz.dev.utils.Service;

import java.util.List;


/**
 * Created by dyz on 2020/06/19.
 */
public interface CaseCommentService extends Service<CaseComment> {
  List<CaseComment> findComments(String empno, Integer caseId);
  List<RateChart> aggregateEmpRate(String moduleName);
}
