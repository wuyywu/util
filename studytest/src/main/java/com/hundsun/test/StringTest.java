package com.hundsun.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/11 20:05
 */
public class StringTest {


    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
//        String a = stringTest.getDefaultRiskType("0", "B");
//        System.out.println(a);
//        String taArray = "99,25,";
//        String[] taList = taArray.split(",");
//        for (String temp : taList){
//            System.out.println("temp: " +temp);
//        }

//        stringTest.buildFailure("测试一些[%s]而已", "1234");
//        String anotherString = null;
//
//        System.out.println("1".compareTo(anotherString));


//        try {
//            System.out.println("0201909091234".substring(1, 9));
//
//            stringTest.appendStringToFixLength("20180911120034", "GBK", 8, " ");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        String con1 = stringTest.appendZeroToFixLength("-1.00", "GBK", 16, 2, "0");
        String content =      null;
        content = content.replaceAll("-","");
        content = stringTest.appendZeroToFixLength(content, "GBK", 15, 2,"0");
        content = "-" + content;
        System.out.println(con1);
        System.out.println(content);
    }

    private String appendZeroToFixLength(String content, String charSet, long fixLength, long precision,String appendChar) {
        long addByte = 0L;
        try {
            if (content == null || content == ""){
                addByte = fixLength;
            }else {
                BigDecimal b = new BigDecimal(content);
                content = b.setScale((int)precision,BigDecimal.ROUND_DOWN).toPlainString();
                content = content.replaceAll("\\.", "");
                addByte = fixLength - content.getBytes(charSet).length;
            }

            StringBuilder sb = new StringBuilder();
            if (addByte > 0) {
                for (int i = 0; i < addByte; i++) {
                    sb.append(appendChar);
                }
            }
            return sb.append(content).toString();
        } catch (Exception e) {
//            logger.warn("DB2File 拼接字符串异常[{}]", e.getMessage());
        }
        return content;
    }


    public static String subStringByBytes(String str, int bytes, String charSetName) throws UnsupportedEncodingException {
        int changdu = str.getBytes(charSetName).length;
        if(changdu > bytes){
            str = str.substring(0, str.length() - 1);
            str = subStringByBytes(str,bytes, charSetName);
        }
        return str;
    }

    private String getDefaultRiskType(String customType, String pubProfessionSubtype) {

        //格式[0:A|5][0:B|5][0:C|5][0:D|5][0:F|5][1:E|5][1:G|5]
        String defultRiskTypeInvestorType = "[0:A|5][0:B|5][0:C|5][0:D|5][0:F|5][1:E|5][1:G|5]";
        String temp = "[" + customType + ":" + pubProfessionSubtype;
        String riskType = null;
        if (defultRiskTypeInvestorType.contains(temp)){
            int index = defultRiskTypeInvestorType.indexOf(temp);
            riskType = defultRiskTypeInvestorType.substring(index+5, index+6);

        }

        return riskType;
    }


    public void buildFailure(String errMessage, Object... args) {
        if (args != null) {
            errMessage = String.format(errMessage, args);
        }
        System.out.println(errMessage);
    }
}
