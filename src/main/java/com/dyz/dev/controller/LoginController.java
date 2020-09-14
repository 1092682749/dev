package com.dyz.dev.controller;

import com.alibaba.fastjson.JSON;
import com.dyz.dev.model.Employee;
import com.dyz.dev.model.LoginUser;
import com.dyz.dev.model.Permission;
import com.dyz.dev.service.EmployeeService;
import com.dyz.dev.service.PermissionService;
import com.dyz.dev.service.RolePermissionService;
import com.dyz.dev.service.RoleService;

import com.dyz.dev.utils.Constants;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.MutableHttpServletRequest;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import com.dyz.dev.utils.cache.PropertiesUtils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static com.dyz.dev.utils.Constants.*;

//import com.dyz.dev.utils.A4.A4Util;
// TODO 另外，需要把xfhan, cdan, mchena, jjren加入管理员队列

@Controller
public class LoginController {
    @Resource
    private EmployeeService employeeService;
    @Value("${isPro}")
    String isPro;
    @Autowired
    CacheUtils cacheUtils;


    @Autowired
    PermissionService permissionService;

    @ResponseBody
    @RequestMapping("/login")
    public Result login(
            @RequestBody Map<String, String> params,
            HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String account = params.get("account");
        String password = params.get("password");
        String domain = params.get("domain");

        // TODO 验证逻辑
        Employee user = employeeService.findBy("mailName", account.toUpperCase());
        String token = cacheUtils.generateToken(user.getMailName());
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
        mutableRequest.putHeader("token", token);
        cacheUtils.login(token, user, request, response);
        return setModuleAndRole(cacheUtils, user, mutableRequest, response, token, domain);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        // dyz by cache
        cacheUtils.remove(cacheUtils.getToken(request), request);
        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ModelAndView("login");
    }


    public Result setModuleAndRole(CacheUtils cacheUtils, Employee employee, MutableHttpServletRequest mutableRequest, HttpServletResponse response, String token, String domain) throws Exception {
        cacheUtils.put(MODULE_NAME, "ALL", mutableRequest);
        return ResultGenerator.successResult(new LoginUser(employee.getMailName(), "",
                employee.getEmpNo(),
                token,
                domain,
                "ALL",
                "admin,admin"));
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
            ex.printStackTrace();
        }
    }
}
