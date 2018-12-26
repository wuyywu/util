package com.hundsun.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/7/24 14:49
 */
public class EnumTest {

    public static void main(String[] args) {
        Map map = new  HashMap();
        map.put(DSNames.fsdpldb.name(), DSNames.fsdpldb.getTablePrefixsByString());

        System.out.println(map);


    }
}
