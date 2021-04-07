package com.sunrise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RedirectController {
    /**
     * 可以用获取到原生HttpServlet对象
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        //String id = request.getSession().getId();
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("获取SessionID:" + id);
        return "first";
    }

    /**
     * 可以注释掉InternalResourceViewResolver试图解析器
     * 使用原生态的HttpServlet来进行转发或者重定向
     * @return
     */
    @RequestMapping("m1/t2")
    public String test2() {
        //return "/WEB-INF/index.jsp";
        //return "forward:/index.jsp";
        System.out.println("重定向方法进入！！！");
        return "redirect:/index.jsp";
    }
}
