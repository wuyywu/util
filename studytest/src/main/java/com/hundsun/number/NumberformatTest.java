package com.hundsun.number;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/3/4 14:44
 */
public class NumberformatTest {

    public static void main(String[] args) {
        String f = "0001000";

        NumberformatTest numberformatTest = new NumberformatTest();
//        System.out.println(numberformatTest.handle(f, 100, 4));

        System.out.println(numberformatTest.appendZeroToFixLength("1.23339", "UTF-8", 8, 4,"0"));
    }


    public String handle(String value, long length, long precision) {
        BigDecimal b = new BigDecimal(value);
        BigDecimal divisor = new BigDecimal(10).pow((int) precision);
        System.out.println(b.divide(divisor).setScale((int) precision).toPlainString());

        return "";
    }

    private String appendZeroToFixLength(String content, String charSet, long fixLength, long precision, String appendChar) {
        long addByte = 0L;
        try {
            BigDecimal b = new BigDecimal(content);
            content = b.setScale((int)precision,BigDecimal.ROUND_DOWN).toPlainString();
            content = content.replaceAll("\\.", "");
            addByte = fixLength - content.getBytes(charSet).length;
            StringBuffer sb = new StringBuffer();
            if (addByte > 0) {
                for (int i = 0; i < addByte; i++) {
                    sb.append(appendChar);
                }
            }
            return sb.append(content).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}
