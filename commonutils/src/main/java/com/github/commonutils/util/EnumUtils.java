package com.github.commonutils.util;

import java.util.*;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/18 13:40
 */
public class EnumUtils {


    /**
     * 获取枚举的所有实例
     * @param enumClass
     * @return
     */
    public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> enumClass) {
        Map<String, E> map = new LinkedHashMap();
        Enum[] arr$ = (Enum[])enumClass.getEnumConstants();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            E e = (E)arr$[i$];
            map.put(e.name(), e);
        }

        return map;
    }

    /**
     * 获取枚举的所有实例
     * @param enumClass
     * @return
     */
    public static <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass) {
        return new ArrayList(Arrays.asList(enumClass.getEnumConstants()));
    }

    /**
     * 判断是否为有效枚举值
     * @param enumClass
     * @param enumName
     * @return
     */
    public static <E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String enumName) {
        if (enumName == null) {
            return false;
        } else {
            try {
                Enum.valueOf(enumClass, enumName);
                return true;
            } catch (IllegalArgumentException var3) {
                return false;
            }
        }
    }

    /**
     * 根据枚举元素名得到枚举对象
     * @param enumClass
     * @param enumName
     * @return
     */
    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName) {
        if (enumName == null) {
            return null;
        } else {
            try {
                return Enum.valueOf(enumClass, enumName);
            } catch (IllegalArgumentException var3) {
                return null;
            }
        }
    }
}
