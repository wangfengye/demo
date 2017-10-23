package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/10/23.
 */
public class TimeUtil {
    public static String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return  date;
    }
}
