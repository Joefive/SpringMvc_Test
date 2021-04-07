package com.sunrise;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //创建对接视图对象
        ModelAndView mv = new ModelAndView();
        //业务代码
        String str = "Hello World...SpringMvc...!!!";
        //对象中传入名称与参数
        mv.addObject("msg",str);
        //视图跳转
        mv.setViewName("frist");
        return mv;
    }
}
