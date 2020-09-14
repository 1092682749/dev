package com.dyz.dev.dao;

import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.RateChart;
import com.dyz.dev.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseCommentMapper extends Mapper<CaseComment> {
  List<CaseComment> findComments(@Param("empno")String empno, @Param("caseId")Integer caseId);
  List<RateChart> aggregateEmpRate(String moduleName);
}
