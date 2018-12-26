package com.hundsun.study;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/4/23 15:10
 */
public class Y2FTest {

    public static String changeY2F(String amount){
        BigDecimal bd=new BigDecimal(amount);
        BigDecimal bd2 = bd.multiply(new BigDecimal(100));

        return bd2.toString();
    }

    public static String changeY2F2(String amount){
        int index = amount.indexOf(".");
        int length = amount.length();
        Long amLong = 0l;
        if(index == -1){
            amLong = Long.valueOf(amount+"00");
        }else if(length - index >= 3){
            amLong = Long.valueOf((amount.substring(0, index+3)).replace(".", ""));
        }else if(length - index == 2){
            amLong = Long.valueOf((amount.substring(0, index+2)).replace(".", "")+0);
        }else{
            amLong = Long.valueOf((amount.substring(0, index+1)).replace(".", "")+"00");
        }
        return amLong.toString();
    }

    public static void main(String args[]){
        changeY2F("0.01");
        changeY2F2("0.01");
        changeY2F2("1.10");
        changeY2F2("1.0");

        changeY2F2("1");


    }
}
