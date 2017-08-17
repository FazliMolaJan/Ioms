package com.hy.ioms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wsw on 2017/4/23.
 */

public class DateUtils {

    public static String getTime(String collectTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CHINA);
        Date date = null;
        try {
            date = df.parse(collectTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df.format(date).replace("T", " ");
    }
    
    public static String getTime(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return df.format(date);
    }
}
