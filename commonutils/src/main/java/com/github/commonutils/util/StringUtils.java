package com.github.commonutils.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author wuyun
 * @date 2018/10/23 20:09
 */
public class StringUtils {
    public static final String EMPTY = "";
    /**
     * ?:0或1个, *:0或多个, +:1或多个
     */
    private static Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    /**
     * 匹配所有的数字 包括负数
     */
    private static Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+\\.?[0-9]*$");


    /**
     * 字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(Object str){
        return str == null || "".equals(str);
    }

    /**
     * 字符串不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * 判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;
        }

        Matcher isNum = NUMBER_PATTERN.matcher(bigStr);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 判断字符串是否是一个日期
     * 必须是yyyy/MM/dd、yyyy-MM-dd、yyyyMMdd这三种样式的字符串
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {

        if (isEmpty(str)) {
            return false;
        }
        String s = str.replaceAll("[/\\- ]", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = format.parse(s);
            if (!format.format(date).equals(s)) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
