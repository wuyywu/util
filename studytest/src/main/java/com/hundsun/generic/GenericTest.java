package com.hundsun.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/14 11:01
 */
public class GenericTest {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        Class stringListClass = stringList.getClass();
        Class interListClass = integerList.getClass();

        if (stringListClass.equals(interListClass)){
            System.out.println(stringListClass.toString());
            System.out.println(interListClass.toString());
            System.out.println("类型相同");
        }






    }
}
