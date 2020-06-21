package com.dyz.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @RequestMapping("/get")
    public ModelAndView get(HttpSession session) {
        session.setAttribute("flag", true);
        return new ModelAndView("textSessionType");
    }
}
