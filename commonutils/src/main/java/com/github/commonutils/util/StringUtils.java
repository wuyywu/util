package com.github.commonutils.util;

/**
 * 字符串工具类
 *
 * @author wuyun
 * @date 2018/10/23 20:09
 */
public class StringUtils {
    public static final String EMPTY = "";

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
}
