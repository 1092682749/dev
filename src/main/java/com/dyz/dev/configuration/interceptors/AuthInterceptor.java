package com.dyz.dev.configuration.interceptors;

import com.dyz.dev.model.User;
import com.dyz.dev.utils.cache.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    CacheUtils cacheUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (cacheUtils.get(request.getSession().getId()) == null) {
            response.sendRedirect("/login");
            String s = request.getRemoteAddr();
//            request.get
//            request.getRemoteHost()
//            cacheUtils.put("what", "???");
            return false;
        }
        return true;
    }
}
