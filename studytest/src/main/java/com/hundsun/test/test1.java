package com.hundsun.test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/8/1 17:39
 */
public class test1 {

    public static void main(String[] args) {
        String[] str = new String[]{"you", "me"};
        List<String> list =  Arrays.asList(str);
        str[0] = "he";
            System.out.println(list.get(0));

    }
}
