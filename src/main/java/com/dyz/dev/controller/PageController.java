package com.dyz.dev.controller;

import com.alibaba.fastjson.JSON;
import com.dyz.dev.model.*;
import com.dyz.dev.utils.Constants;
import com.dyz.dev.utils.ConstantsConstants;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @RequestMapping("/page")
    public String page() {
        return "material-from";
    }

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/fileInput")
    public String fileInput() {
        return "file-input";
    }


}
