package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangfeng
 * @describe TODO
 * @date 2017/10/23
 */
public class TimeUtil {
    public static String getTime(){
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        // 设置日期格式
        String date = df.format(new Date());
        return  date;
    }
}
