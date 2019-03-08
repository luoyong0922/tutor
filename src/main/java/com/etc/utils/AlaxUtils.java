package com.etc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlaxUtils {
    //生成一个id
    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }
}
