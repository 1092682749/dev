package com.dyz.dev.configuration.interceptors;

import com.alibaba.fastjson.JSON;
import com.dyz.dev.model.Employee;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.utils.cache.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SessionInterceptor implements HandlerInterceptor {
  private CacheUtils cacheUtils;
  public static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

  public SessionInterceptor(CacheUtils cacheUtils) {
    this.cacheUtils = cacheUtils;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    String token = cacheUtils.getToken(request);
    Result result = ResultGenerator.errResult(401, "用户没有登录");
    if (token == null) {
      responseResult(response, result, 401);
      return false;
    }
    try {
      Object o = cacheUtils.get(token, request);
      if (o == null) {
        responseResult(response, result, 401);
        return false;
      }
      if (o instanceof Employee) {
        cacheUtils.login(token, o, request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.info(e.getMessage());
      result.setMessage(e.getMessage());
      responseResult(response, result, 401);
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }

  private void responseResult(HttpServletResponse response, Result result, int status) {
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Content-type", "application/json;charset=UTF-8");
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "*");
    response.setStatus(status);
    try {
      PrintWriter writer = response.getWriter();
      writer.write(JSON.toJSONString(result));
      writer.close();
    } catch (IOException ex) {
      logger.info(ex.getMessage());
    }
  }
}
