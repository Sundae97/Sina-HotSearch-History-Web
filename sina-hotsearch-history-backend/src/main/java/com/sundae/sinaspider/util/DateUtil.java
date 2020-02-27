package com.sundae.sinaspider.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * ignore second
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");

    public static String timeToDateString(long time){
        return dateFormat.format(new Date(time));
    }
}
