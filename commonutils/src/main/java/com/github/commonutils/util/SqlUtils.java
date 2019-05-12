package com.github.commonutils.util;

import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/14 20:30
 */
public class SqlUtils {

    public static String formatSql(String sql, Object parameterObject, List<ParameterMapping> parameterMappingList) {
        if (sql != null && sql.length() != 0) {
            sql = beautifySql(sql);
            if (parameterObject != null && parameterMappingList != null && parameterMappingList.size() != 0) {
                try {
                    if (parameterMappingList != null) {
                        Class<?> parameterObjectClass = parameterObject.getClass();
                        if (isStrictMap(parameterObjectClass)) {
                            StrictMap<Collection<?>> strictMap = (StrictMap)parameterObject;
                            if (isList(((Collection)strictMap.get("list")).getClass())) {
                                sql = handleListParameter(sql, (Collection)strictMap.get("list"));
                            }
                        } else if (!isMapInstance(parameterObject) && !isMap(parameterObjectClass)) {
                            sql = handleCommonParameter(sql, parameterMappingList, parameterObjectClass, parameterObject);
                        } else {
                            Map<?, ?> paramMap = (Map)parameterObject;
                            sql = handleMapParameter(sql, paramMap, parameterMappingList);
                        }
                    }

                    return sql;
                } catch (Exception var6) {
                    return sql;
                }
            } else {
                return sql;
            }
        } else {
            return "";
        }
    }

    public static String beautifySql(String sql) {
        sql = sql.replaceAll("[\\s\n ]+", " ");
        return sql;
    }

    public static String handleListParameter(String sql, Collection<?> col) {
        String value;
        if (col != null && col.size() != 0) {
            for(Iterator var3 = col.iterator(); var3.hasNext(); sql = sql.replaceFirst("\\?", value)) {
                Object obj = var3.next();
                value = null;
                Class<?> objClass = obj.getClass();
                if (isPrimitiveOrPrimitiveWrapper(objClass)) {
                    value = obj.toString();
                } else if (objClass.isAssignableFrom(String.class)) {
                    value = "'" + obj.toString() + "'";
                }
            }
        }

        return sql;
    }

    public static String handleMapParameter(String sql, Map<?, ?> paramMap, List<ParameterMapping> parameterMappingList) {
        Iterator var4 = parameterMappingList.iterator();

        while(true) {
            while(var4.hasNext()) {
                ParameterMapping parameterMapping = (ParameterMapping)var4.next();
                String propertyName = parameterMapping.getProperty();
                if (!paramMap.containsKey(propertyName) && propertyName.contains(".")) {
                    String[] strs = propertyName.split("\\.");
                    Object propertyValue = paramMap.get(strs[0]);
                    if (propertyValue != null) {
                        if (propertyValue instanceof Map) {
                            sql = replaceString(strs[1], (Map)propertyValue, sql);
                        } else {
                            Object value = getFieldValue4Method(propertyValue, strs[1]);
                            sql = replaceString(value, sql);
                        }
                    }
                } else {
                    sql = replaceString(propertyName, paramMap, sql);
                }
            }

            return sql;
        }
    }

    private static String replaceString(Object propertyValue, String sql) {
        if (propertyValue != null) {
            if (propertyValue.getClass().isAssignableFrom(String.class)) {
                String value = propertyValue.toString();
                if ("null".equals(value)) {
                    value = "";
                }

                propertyValue = "'" + value + "'";
            }

            sql = sql.replaceFirst("\\?", propertyValue.toString());
        }

        return sql;
    }

    private static String replaceString(String propertyName, Map paramMap, String sql) {
        Object propertyValue = paramMap.get(propertyName);
        if (propertyValue != null) {
            if (propertyValue.getClass().isAssignableFrom(String.class)) {
                String value = propertyValue.toString();
                if ("null".equals(value)) {
                    value = "";
                }

                propertyValue = "'" + value + "'";
            }

            sql = sql.replaceFirst("\\?", propertyValue.toString());
        }

        return sql;
    }

    public static String handleCommonParameter(String sql, List<ParameterMapping> parameterMappingList, Class<?> parameterObjectClass, Object parameterObject) throws Exception {
        String propertyValue;
        for(Iterator var5 = parameterMappingList.iterator(); var5.hasNext(); sql = sql.replaceFirst("\\?", propertyValue)) {
            ParameterMapping parameterMapping = (ParameterMapping)var5.next();
            propertyValue = null;
            if (isPrimitiveOrPrimitiveWrapper(parameterObjectClass)) {
                propertyValue = parameterObject.toString();
            } else {
                String propertyName = parameterMapping.getProperty();
                Field field = parameterObjectClass.getDeclaredField(propertyName);
                field.setAccessible(true);
                Object obj = field.get(parameterObject);
                propertyValue = String.valueOf(obj);
                if (parameterMapping.getJavaType().isAssignableFrom(String.class) && obj != null) {
                    propertyValue = "'" + propertyValue + "'";
                }
            }
        }

        return sql;
    }

    public static boolean isPrimitiveOrPrimitiveWrapper(Class<?> parameterObjectClass) {
        return parameterObjectClass.isPrimitive() || parameterObjectClass.isAssignableFrom(Byte.class) || parameterObjectClass.isAssignableFrom(Short.class) || parameterObjectClass.isAssignableFrom(Integer.class) || parameterObjectClass.isAssignableFrom(Long.class) || parameterObjectClass.isAssignableFrom(Double.class) || parameterObjectClass.isAssignableFrom(Float.class) || parameterObjectClass.isAssignableFrom(Character.class) || parameterObjectClass.isAssignableFrom(Boolean.class);
    }

    public static boolean isStrictMap(Class<?> parameterObjectClass) {
        return parameterObjectClass.isAssignableFrom(StrictMap.class);
    }

    public static boolean isList(Class<?> clazz) {
        Class[] interfaceClasses = clazz.getInterfaces();
        Class[] var5 = interfaceClasses;
        int var4 = interfaceClasses.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Class<?> interfaceClass = var5[var3];
            if (interfaceClass.isAssignableFrom(List.class)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isMapInstance(Object obj) {
        return obj instanceof Map;
    }

    public static boolean isMap(Class<?> parameterObjectClass) {
        Class[] interfaceClasses = parameterObjectClass.getInterfaces();
        Class[] var5 = interfaceClasses;
        int var4 = interfaceClasses.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Class<?> interfaceClass = var5[var3];
            if (interfaceClass.isAssignableFrom(Map.class)) {
                return true;
            }
        }

        return false;
    }

    public static Object getFieldValue4Method(Object obj, String propertyName) {
        try {
            Class clazz = obj.getClass();
            String methodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
            Method getMethod = clazz.getMethod(methodName);
            return getMethod.invoke(obj);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

}
