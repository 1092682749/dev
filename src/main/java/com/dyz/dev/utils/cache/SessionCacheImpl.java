package com.dyz.dev.utils.cache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SessionCacheImpl implements CacheUtils{
    @Override
    public void put(String key, Object value, HttpServletRequest request) throws NoSupportCacheType {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    @Override
    public Object get(String key,HttpServletRequest request) throws NoSupportCacheType {
        HttpSession session = request.getSession();
        Object o = session.getAttribute(key);
        return o;
    }

    @Override
    public void remove(String key, HttpServletRequest request) {
        request.getSession().removeAttribute(key);
    }

  @Override
  public String getToken(HttpServletRequest request) {
    String token = "";
    // 不分离时从Cookie里面取
    if (request.getCookies() == null) return null;
    List<Cookie> cookieList = Arrays.asList(request.getCookies()).stream().filter(i -> "token".equals(i.getName())).collect(Collectors.toList());
    if (cookieList.size() == 0) return null;
    token = cookieList.get(0).getValue();
    return token;
  }
}
