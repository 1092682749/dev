package com.dyz.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class GoToPages {
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("tb")
    public String tb() {
        return "testBootStrap";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("getkeys")
    public void getkeys() {
        Set<Object> sets = redisTemplate.keys("*");
        sets.forEach(i -> {
            System.out.println(i);
            System.out.println(redisTemplate.opsForValue().get(i));
        });
    }
}
