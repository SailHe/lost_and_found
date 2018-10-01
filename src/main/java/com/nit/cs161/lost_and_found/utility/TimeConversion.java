package com.nit.cs161.lost_and_found.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CaiTieZhu on 2018/5/22 15:21
 */

/** 时间格式转换以及求和 By CaiTieZhu*/
public class TimeConversion {

    public static void main(String[] args) throws ParseException {
        TimeConversion timeConversion = new TimeConversion();
        timeConversion.TimeChanger("2015-07-31",20);
    }

    public String TimeChanger(String time,int number) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(time);
        Date newDate = addDate(date, number);
        time = String.valueOf(dateFormat.format(newDate));
        System.out.println(time);
        return time;
    }

    public static Date addDate(Date date,long day) throws ParseException {
        long time = date.getTime();
        day = day*24*60*60*1000;
        time+=day;
        return new Date(time);
    }
}
