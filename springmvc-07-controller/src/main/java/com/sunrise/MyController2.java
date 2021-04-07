package com.sunrise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 增加@Controller注解，可以被spring接管，
 * 如果有方法返回的String，可以直接被试图解析器进行解析mv
 */
@Controller
@RequestMapping("/admin")
public class MyController2 {
    @RequestMapping("/f2")
    public String test(Model model) {
        model.addAttribute("msg", "MyController2");
        return "first";   //WEB-INF/jsp/first.jsp
    }
}
