package com.sunrise.controller;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunrise.pojo.User;
import com.sunrise.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用jackson中ObjectMapper对象，将所创建的对象进行转化为json对象
 * 1.单独解决乱码：@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
 * 2.统一解决乱码：从新配置spring-mvc配置文件加入自带过滤器
 * 3.@RestController表示这个类的方法只会返回字符串，替代了@ResponseBody注解，不用每个类都写
 */
//@Controller
@RestController
public class JsonController {

    //单独解决乱码
    //@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @RequestMapping("j1")
    //@ResponseBody //不会走试图解析器,直接返回字符串
    public String jackson() throws JsonProcessingException {
        //jackson对象
        ObjectMapper om = new ObjectMapper();
        User user = new User("张三", 12, "男");
        String s = om.writeValueAsString(user);
        return s;
    }

    @RequestMapping("j2")
    public String jackson2() throws JsonProcessingException {
        //jackson对象
        ObjectMapper om = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        User user = new User("张一", 12, "男");
        User user1 = new User("张二", 12, "男");
        User user2 = new User("张三", 12, "男");
        User user3 = new User("张四", 12, "男");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String s = om.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("j3")
    public String jackson3() throws JsonProcessingException {
        //jackson对象
        ObjectMapper om = new ObjectMapper();
        //时间戳timestamp
        Date dd = new Date();
        //自定义时间类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return om.writeValueAsString(sdf.format(dd));
    }

    @RequestMapping("j4")
    public String jackson4() throws JsonProcessingException {
        //时间戳timestamp
        Date dd = new Date();
        return JsonUtil.getJson(dd, "yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("j5")
    public String jackson5() throws JsonProcessingException {
        List<User> userList2 = new ArrayList<User>();
        User user = new User("张五", 12, "男");
        User user1 = new User("张六", 12, "男");
        User user2 = new User("张柒", 12, "男");
        User user3 = new User("张捌", 12, "男");

        userList2.add(user);
        userList2.add(user1);
        userList2.add(user2);
        userList2.add(user3);

        String json = JSON.toJSONString(userList2);
        return json;
    }

}
