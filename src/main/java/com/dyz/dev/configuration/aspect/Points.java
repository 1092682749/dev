package com.dyz.dev.configuration.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Points {
  @Pointcut("execution(public * com.dyz.dev.controller.CaseFormController.list(..))")
  public void caseList() {

  }
  @Pointcut("execution(public * com.dyz.dev.controller.CaseFormController.detail(..))")
  public void caseDetails() {

  }
}
