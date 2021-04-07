package com.sunrise;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//先导入Controller接口
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String link;
        //模型和视图对象
        ModelAndView mv = new ModelAndView();
        System.out.println("模型创建成功！");
        //封装对象放入mv对象中
        mv.addObject("msg", "Hello SpringMvc....!!!");
        System.out.println("对象封装成功!");
        //封装需要跳转或重定向的视图
        mv.setViewName("hello"); //:/WEB-INF/jsp/hello.jsp
        return mv;
    }
}
