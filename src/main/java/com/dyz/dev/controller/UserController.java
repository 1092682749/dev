package com.dyz.dev.controller;
import	java.util.HashMap;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.model.User;
import com.dyz.dev.service.UserService;
import com.dyz.dev.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.channels.AsynchronousChannel;
import java.util.List;
import java.util.Map;

/**
* Created by dyz on 2019/06/12.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Autowired
    @Qualifier("towDataSource")
    DataSource towDataSource;

    @Autowired
    @Qualifier("oneDataSource")
    DataSource oneDataSource;

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
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
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

    @ResponseBody
    @RequestMapping("/change")
    public String change() {
    DruidDataSource oneDruidDataSource = (DruidDataSource) oneDataSource;
    DruidDataSource towDruidDataSource = (DruidDataSource) towDataSource;
    ((DruidDataSource) oneDruidDataSource).setPassword("root111");
    towDruidDataSource.setPassword("root111");
    return "成功设置!";
}
}























