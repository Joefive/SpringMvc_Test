package com.sunrise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SpringMvcAnnotation {
    @RequestMapping("/first")
    public String first(Model m1) {
        //Model封装数据
        m1.addAttribute("msg","SpringMvc annotation..!");
        return "first";   //会被视图解析器处理返回字符串
    }
}
