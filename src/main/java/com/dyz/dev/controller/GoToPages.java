package com.dyz.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoToPages {
    @RequestMapping("tb")
    public String tb() {
        return "testBootStrap";
    }
}
