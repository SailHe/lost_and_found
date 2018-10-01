package com.nit.cs161.lost_and_found.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: 日期时间生成器类<p>
 * 构造器(String, Long, Date)
 * 转换器(String, Long, Date, Timestamp)<p>
 *
 * @author: SailHe
 * @date: 2018/4/3 14:47
 */
public class DateGenerator {
    /**
     * Descriptions: default format<p>
     *
     * @author SailHe
     * @date 2018/4/3 16:52
     */
    private static SimpleDateFormat dateFormatBuffer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat dateFormat = dateFormatBuffer;
    private Date buffer = null;

    /**
     * Descriptions: 改变该对象的格式(toString输出时自动转换)<p>
     *
     * @author SailHe
     * @date 2018/4/3 16:42
     */
    public DateGenerator resetFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    /**
     * Descriptions: 这会对之后所有的造成影响 慎用<p>
     *
     * @author SailHe
     * @date 2018/7/27 18:43
     */
    public static void setFormat(SimpleDateFormat dateFormat) {
        dateFormatBuffer = dateFormat;
    }

    public DateGenerator(String date) {
        this(dateFormatBuffer, date);
    }

    public DateGenerator(Date date) {
        buffer = date;
    }

    public DateGenerator(SimpleDateFormat dateFormat, String date) {
        try {
            this.dateFormat = dateFormat;
            buffer = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public DateGenerator(Long date) {
        buffer = new Date(date);
    }

    @Override
    public String toString() {
        return dateFormat.format(buffer);
    }

    public Date toDate() {
        return buffer;
    }

    public Long toLong() {
        return buffer.getTime();
    }

    public Timestamp toTimestamp() {
        return new Timestamp(buffer.getTime());
    }

    /**
     * Descriptions: Demo<p>
     *
     * @author SailHe
     * @date 2018/4/3 16:53
     */
//    public static void main(String[] args) {
//        Date now = new Date();
//        System.out.println("Date类直接输出: " + now);
//
//        DateGenerator demo = new DateGenerator(now);
//        System.out.println("Date类构造: " + demo);
//
//        demo.resetFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//        System.out.println("格式变换后: " + demo);
//
//        System.out.println("字符串构造: " + new DateGenerator(demo.toString()));
//        System.out.println("字符串构造: " + new DateGenerator(demo.toDate()).toString());
//
//        System.out.println("Long输出" + demo.toLong());
//        System.out.println("Long构造: " + new DateGenerator(demo.toLong()));
//    }
}
