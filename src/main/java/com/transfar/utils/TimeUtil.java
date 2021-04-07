package com.transfar.utils;


import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeUtil {

    public static String getCurrentTime(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date()).toString();// new Date()为获取当前系统时间
    }

}
