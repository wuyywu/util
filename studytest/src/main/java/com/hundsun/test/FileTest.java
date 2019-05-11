package com.hundsun.test;

import java.io.File;
import java.text.DecimalFormat;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/4/30 11:42
 */
public class FileTest {

    public static void main(String[] args) {
        String liqFileExportPath = "D:/test1";
        File directory = new File(liqFileExportPath);
        if (!(directory.exists() && directory.isDirectory())) {
            assert directory.mkdirs();
        }

        String liqFileExportPath1 = "D:/test2";
        File directory2 = new File(liqFileExportPath1);
        if (!(directory2.exists() && directory2.isDirectory())) {
            directory2.mkdirs();
        }
        DecimalFormat df = new DecimalFormat();
        System.out.println(df.format(13));


        System.out.println(supplementZero("0", 8));
    }

    private static String supplementZero(String oriStr, Integer len){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len-oriStr.length(); i++) {
            builder.append("0");
        }
        builder.append(oriStr);
        return builder.toString();
    }
}
