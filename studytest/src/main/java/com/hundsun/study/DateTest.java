package com.hundsun.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/4/23 17:03
 */
public class DateTest {

    public static void main(String[] args){
/*        String date = "20150612";

        SimpleDateFormat date1 = new SimpleDateFormat("yyyyMMdd");
        Date date2 = null;

        try {
            date2 = date1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String date3 = dateTimeToStr(date2, "yyyy-MM-dd");


        String transtime = date3 + " " + getNowDate("HH:mm:ss");*/

//        try {
//            String transtime = dateStrConvert("2018-05-08 11:52:16", "yyyy-MM-dd HH:mm:ss", "yyyyMMdd");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        String a = getCurrentTime();
        System.out.println(a);

    }

    public static String dateStrConvert(String str, String fmtSrc,
                                        String fmtDst) throws ParseException {
        Date date = strToDateTime(str, fmtSrc);
        return dateTimeToStr(date, fmtDst);
    }

    public static Date strToDateTime(String str, String format) throws
            ParseException {
        try {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
            return bartDateFormat.parse(str);
        } catch (ParseException ex) {
            throw ex;
        }
    }

    public static String dateTimeToStr(Date date, String format) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
        return bartDateFormat.format(date);
    }

    public static String getNowDate(String format){
        if (format == null || "".equals(format)){
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        java.util.Date currentTime = new java.util.Date();//得到当前系统时间
        String now_date = formatter.format(currentTime); //将日期时间格式化
        return now_date;

    }


    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.SECOND, -60);// 3分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String time = sdf.format(beforeD);
        return time;
    }
}
