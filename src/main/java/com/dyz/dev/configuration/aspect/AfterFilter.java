package com.dyz.dev.configuration.aspect;

import com.dyz.dev.model.CaseForm;
import com.dyz.dev.utils.PageBean;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.apache.ibatis.annotations.Case;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.dyz.dev.utils.Constants.MODULE_NAME;


@Component
@Aspect
public class AfterFilter {
  @Autowired
  CacheUtils cacheUtils;
  Logger logger = LoggerFactory.getLogger(AfterFilter.class.getName());

//  @AfterReturning(pointcut = "com.dyz.dev.configuration.aspect.Points.caseList()", returning = "ret")
//  public Object caseList(JoinPoint joinPoint, Object ret) throws NoSupportCacheType {
//    Result result = (Result) ret;
//    Object[] args = joinPoint.getArgs();
//    HttpServletRequest request = (HttpServletRequest) args[1];
//    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
//    if (moduleName == null) {
//      result.setCode(302);
//      result.setMessage("您没有被任何模块所包含");
//      result.setData(new ArrayList<>());
//      return  result;
//    }
//    PageBean<CaseForm> pageBean = (PageBean<CaseForm>) result.getData();
//    List<CaseForm> caseFormList = pageBean.getList();
//    caseFormList = caseFormList.stream()
//      .filter(i -> moduleName.equals(i.getModuleName()))
//      .collect(Collectors.toList());
//    logger.info(caseFormList.size() + "");
//    return caseFormList;
//  }

//  @Around("com.dyz.dev.configuration.aspect.Points.caseList()")
//  public Object caseList(ProceedingJoinPoint joinPoint) throws Throwable {
//    Result result = (Result) joinPoint.proceed();
//    Object[] args = joinPoint.getArgs();
//    HttpServletRequest request = (HttpServletRequest) args[1];
//    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
//    if (moduleName == null) {
//      result.setCode(302);
//      result.setMessage("您没有被任何模块所包含");
//      result.setData(new ArrayList<>());
//      return  result;
//    }
//    PageBean<CaseForm> pageBean = (PageBean<CaseForm>) result.getData();
//    List<CaseForm> caseFormList = pageBean.getList();
//    caseFormList = caseFormList.stream()
//      .filter(i -> moduleName.equals(i.getModuleName()))
//      .collect(Collectors.toList());
//    logger.info(caseFormList.size() + "");
//    result.setData(caseFormList);
//    return result;
//  }

//  @AfterReturning(pointcut = "com.dyz.dev.configuration.aspect.Points.caseDetails()", returning = "ret")
//  public Object caseDetails(JoinPoint joinPoint, Object ret) throws NoSupportCacheType {
//    Result result = (Result) ret;
//    Object[] args = joinPoint.getArgs();
//    HttpServletRequest request = (HttpServletRequest) args[1];
//    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
////    List<CaseForm> caseFormList = (List<CaseForm>) result.getData();
////    caseFormList = caseFormList.stream()
////      .filter(i -> moduleName.equals(i.getModuleName()))
////      .collect(Collectors.toList());
//    CaseForm caseForm = (CaseForm) result.getData();
//    if (moduleName.equals(caseForm.getModuleName())) return ret;
//    result.setData("");
//    result.setMessage("无权限");
//    return result;
//  }
}
