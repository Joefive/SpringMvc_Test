package com.sunrise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * RestFul风格使用
 * 方法中使用@PathVariable注解，进行映射到对应的@RequestMapping中
 * RequestMapping分类：
 *
 * @GetMapping == @RequestMapping(method = RequestMethod.GET)
 * @PostMapping
 * @DeleteMapping
 * @PutMapping
 * @PatchMapping
 */

@Controller
public class RestFulController {
    //原来链接方式：http://localhost:8080/s7/first?a=1&b=2
    //RestFul方式：http://localhost:8080/s7/a/b
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String restFul1(@PathVariable int a, @PathVariable int b, Model model) {
        int str = a + b;
        model.addAttribute("msg", "结果为1：" + str);
        return "first";
    }

    @PostMapping("/add/{a}/{b}")
    public String restFul2(@PathVariable int a, @PathVariable String b, Model model) {
        String str = a + b;
        model.addAttribute("msg", "结果为2：" + str);
        return "first";
    }
}

