package com.dyz.dev.dao;

import com.dyz.dev.model.CaseForm;
import com.dyz.dev.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseFormMapper extends Mapper<CaseForm> {
  public List<CaseForm> findAllCaseInfo(@Param("empno") String empno, @Param("moduleName")List<String> moduleName);
  public CaseForm findInfoById(@Param("empno") String empno, @Param("caseId") Integer caseId);
  public List<CaseForm> findByIds(@Param("empno") String empno,
                                  @Param("moduleName")List<String> moduleName,
                                  @Param("idList")List<Integer> idList);
  public List<CaseForm> Oldest(@Param("empno") String empno, @Param("moduleName")List<String> moduleName);
}
