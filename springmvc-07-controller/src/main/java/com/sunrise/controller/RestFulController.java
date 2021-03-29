package com.sunrise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
    @RequestMapping("/add")
    public String restFul(int a, int b, Model model) {
        int str = a + b;
        model.addAttribute("msg", "结果为：" + str);
        return "first";
    }
}

