package com.hundsun.study;

import java.io.*;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/5/30 14:22
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\wuyun11584\\Desktop\\SHOP.105290073991061.20180729.txt";
        File file = new File(filePath);

        FileInputStream is = null;
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;

        is = new FileInputStream(file);

        read = new InputStreamReader(is, "UTF-8");
        bufferedReader = new BufferedReader(read);

        String lineTxt;
        String[] a = {};
        while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
            a = lineTxt.split("\\t", -1);
            int i = 0;
            i ++;
            if (i == 3){
                break;
            }
        }

        String[] b = {};
        String filePathOld = "C:\\Users\\wuyun11584\\Desktop\\SHOP.105290073991061.20180730164644.txt";
        File fileOld = new File(filePathOld);


        FileInputStream isold = null;
        InputStreamReader readold = null;
        BufferedReader bufferedReaderold = null;
        isold = new FileInputStream(fileOld);

        readold = new InputStreamReader(isold, "UTF-8");
        bufferedReaderold = new BufferedReader(readold);

        String lineTxtold;

        while ((lineTxtold = bufferedReaderold.readLine()) != null) {
            System.out.println(lineTxtold);
            b = lineTxtold.split("\\t", -1);

            int i = 0;
            i ++;
            if (i == 3){
                break;
            }
        }

        for (int i = 0; i<b.length;i++) {
            b[i] = b[i].trim();
        }

        System.out.println(a.toString());
        System.out.println(b.toString());

    }

}
