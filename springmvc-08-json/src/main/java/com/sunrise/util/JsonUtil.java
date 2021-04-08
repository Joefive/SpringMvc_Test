package com.sunrise.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;

/**
 * Json工具类
 * 重写思想：重写方法可以调用已完成方法，只是参数不一样多少
 */
public class JsonUtil {
    //重写方法
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String dateFormat) {
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        om.setDateFormat(simpleDateFormat);
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
