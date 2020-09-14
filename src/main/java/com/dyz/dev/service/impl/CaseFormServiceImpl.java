package com.dyz.dev.service.impl;

import com.dyz.dev.dao.CaseFormMapper;
import com.dyz.dev.model.CaseComment;
import com.dyz.dev.model.CaseForm;
import com.dyz.dev.service.CaseCommentService;
import com.dyz.dev.service.CaseFormService;
import com.dyz.dev.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by dyz on 2020/06/15.
 */
@Service
@Transactional
public class CaseFormServiceImpl extends AbstractService<CaseForm> implements CaseFormService {
  @Resource
  private CaseFormMapper solveCenterTblCaseFormMapper;

  @Resource
  private CaseCommentService caseCommentService;

  @Override
  public List<CaseForm> findAllCaseInfo(String empno, String moduleName) {
    List<String> moduleNames = Arrays.asList(moduleName.split(",")).stream().filter(i -> !"".equals(i)).collect(Collectors.toList());

    List<CaseForm> caseFormList = solveCenterTblCaseFormMapper.findAllCaseInfo(empno, moduleNames);
//    caseFormList.sort((i, j) -> (int) (j.getCreateDate().getTime() - i.getCreateDate().getTime()));
    return caseFormList;
  }

  @Override
  public CaseForm findInfoById(String empno, Integer caseId) {
    return solveCenterTblCaseFormMapper.findInfoById(empno, caseId);
  }

  @Override
  public List<CaseForm> findByIds(String empno, String moduleName, List<Integer> idList) {
    List<String> moduleNames = Arrays.asList(moduleName.split(",")).stream().filter(i -> !"".equals(i)).distinct().collect(Collectors.toList());
    if (idList.size() == 0) {
      return new ArrayList<>();
    }
    return solveCenterTblCaseFormMapper.findByIds(empno, moduleNames, idList);
  }

  @Override
  public void accept(CaseComment caseComment) {
    CaseComment caseCommentDB = caseCommentService.findByStringId(caseComment.getCommentId().toString());
    caseCommentDB.setAccept("Y");
    CaseForm caseForm = this.findByStringId(caseComment.getCaseId().toString());
    caseForm.setStatus("accept");
    caseCommentService.update(caseCommentDB);
    update(caseForm);
  }

  @Override
  public List<CaseForm> Oldest(String empno, String moduleName) {
    List<String> moduleNames = Arrays.asList(moduleName.split(",")).stream().filter(i -> !"".equals(i)).collect(Collectors.toList());

    return solveCenterTblCaseFormMapper.Oldest(empno, moduleNames);
  }

}
