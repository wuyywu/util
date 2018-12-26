package com.hundsun.test;

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

        stringTest.buildFailure("测试一些[%s]而已", "1234");
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
