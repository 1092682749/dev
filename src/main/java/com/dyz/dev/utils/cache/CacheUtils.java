package com.dyz.dev.utils.cache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 缓存工具可以使用
 */
public interface CacheUtils {
    public void put(String key, Object value, HttpServletRequest request) throws NoSupportCacheType;

    default public void login(String key, Object value, HttpServletRequest request, HttpServletResponse response) throws NoSupportCacheType {
        put(key, value, request);
      // 前后端不分离时的实现
//        Cookie cookie = new Cookie("token", key);
//        String path = request.getContextPath();
//        cookie.setPath(request.getContextPath());
//        cookie.setDomain("f");
//        cookie.setMaxAge(30 * 60);
//        response.addCookie(cookie);
    }

    public Object get(String key, HttpServletRequest request) throws NoSupportCacheType;

    public void remove(String key, HttpServletRequest request);

    default public String getToken(HttpServletRequest request) {
      String token = "";
      // 前后端分离项目，只需要把token返回给前端，前端会把token写到header里。因此获取token方式为header里拿；
      token = request.getHeader("token");
        return token;
    }

    default public Object getUser(HttpServletRequest request) throws NoSupportCacheType {
      String token = getToken(request);
      return get(token, request);
    }

    default public String generateToken(String keyWord) {
        return keyWord + "_thisismydefinetoken_" + new Date().getTime();
    }

    default public boolean validToken(String token) throws ParseException {
//      String[] arr = token.split("-");
//      Date date = new Date(Long.valueOf(arr[arr.length - 1]));
      return  true;
    }

}
