package com.htht.General;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

    public static String getTimeStr(String Fromat){
        SimpleDateFormat df = new SimpleDateFormat(Fromat);//设置时间格式
        return df.format(new Date());//获取当前时间
    }
}
