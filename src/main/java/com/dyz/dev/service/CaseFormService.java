package com.dyz.dev.service;
import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.CaseForm;
import com.dyz.dev.utils.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by dyz on 2020/06/15.
 */
public interface CaseFormService extends Service<CaseForm> {
  public List<CaseForm> findAllCaseInfo(String empno, String moduleName);
  public CaseForm findInfoById(String empno, Integer caseId);
  public List<CaseForm> findByIds(@Param("empno") String empno, String moduleName, @Param("idList")List<Integer> idList);
  void accept(CaseComment caseComment);
  List<CaseForm> Oldest(String empno, String moduleName);
}
