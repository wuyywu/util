package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/5/29 15:42
 */
public class stringSpiltTest {
    public static void  main(String[] args){
        String filename = "a.txt";
        String[] fileNameArray = filename.split("\\|");
        System.out.println(fileNameArray[0]);
    }
}
