package com.sunrise.controller;


import com.sunrise.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 增加@RequestParam注解后，前端传递的参数与注解中一致就能接收到前端参数
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/t1")
    //1.接受前端参数 通过String name直接接收
    //http://localhost:8080/s7/user/t1?name=zhangsan
    public String test1(@RequestParam("username") String name, Model model){
        System.out.println("接收到前端参数："+ name);
        //2.返回结果传递给前段
        model.addAttribute("msg",name);
        //3.跳转视图
        return "first";
    }

    /**
     * 前端接收一个对象
     */
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "first";
    }
}
