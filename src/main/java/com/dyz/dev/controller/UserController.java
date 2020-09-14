package com.dyz.dev.controller;
import	java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.dyz.dev.model.User;
import com.dyz.dev.service.UserService;
import com.dyz.dev.utils.PageBean;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;

import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.channels.AsynchronousChannel;
import java.util.List;
import java.util.Map;

import static com.dyz.dev.utils.Constants.MODULE_NAME;

/**
* Created by dyz on 2019/06/12.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private CacheUtils cacheUtils;

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        userService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Object id) {
        User user = null;
        if (id instanceof String) {
        	user = userService.findByStringId((String)id);
        } else {
        	user = userService.findById((Integer)id);
        }

        return ResultGenerator.successResult(user);
    }


    @GetMapping("/list")
    public List<User> list(PageBean<User> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<User> list = userService.findAll();
        page.setList(list);
        ModelAndView mav = new ModelAndView("userlist");
        mav.addObject("users", list);
        System.out.println("asd");
        list.clear();
        return list;
    }

  @GetMapping("/auth")
  public Result auth(HttpServletRequest request) throws NoSupportCacheType {
    String permissions = (String) cacheUtils.get("permissions", request);
    String roles = (String) cacheUtils.get("roles", request);
    roles += "," + cacheUtils.get(MODULE_NAME, request);
    Map<String,String> auth = new HashMap<>();
    auth.put("permissions",permissions);
    auth.put("roles",roles);
    return ResultGenerator.successResult(auth);
  }

}























