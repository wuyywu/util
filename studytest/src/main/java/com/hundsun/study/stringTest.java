package com.hundsun.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/4/16 16:51
 */
public class stringTest {

    private static Random random = new Random();
    public static void main(String[] agrs){
/*        String text = "001|2500000003|20180402000023|M|20180404000007|124|25|1000.00|42900619910218429X|002|中国工商银行|6228480321097844214|张三|156|20180402|6228481234567|123456|150600|0|432980|0|250001|2||||350002||20180402|||1|1|50|5030|20180404|20180404|0001|250000001|A|||150900|18768177589|002|03|1|";

        String s[] = text.split("\\|",-1);
        System.out.println(s.length);*/

/*        Map m = new HashMap();
        m.put("dir", Boolean.valueOf(false));

        String flag = m.get("dir").toString();

        if (Boolean.valueOf(flag) == false)
            System.out.println(flag);

        System.out.println(flag);*/

/*        String remote = "/PayBatch_OUT_001_20180329.txt";
        if(remote.indexOf(".") > -1){
            int i = remote.lastIndexOf("/");
            String dir = remote.substring(0, remote.lastIndexOf("/"));
            String fil = remote.substring(remote.lastIndexOf("/")+1);
        }*/
        //String test = getRandom(16);
        String lineTxt = "总笔数：2";
        String lineTxt2 = "总笔数:2";

        String date = "2017-10-12 22:24:47".replaceAll("-", "").substring(0,8);

        //第一行获取总笔数
        int index = lineTxt.lastIndexOf(":");
        if (index == -1) index = lineTxt.lastIndexOf("：");
        int num = Integer.parseInt(lineTxt.substring(index+1));

        int index2 = lineTxt2.lastIndexOf(":");
        if (index2 == -1) index = lineTxt2.lastIndexOf("：");
        int num2 = Integer.parseInt(lineTxt2.substring(index2+1));

        StringBuffer sb = new StringBuffer("22288|11122|");
        String ab = sb.substring(sb.length()-1);
        boolean flag = "|".equals(ab);
    }
    public static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
            if (isChar) { // 字符串
                int choice = (random.nextInt(2) % 2 == 0) ? 65 : 97; // 取得大写字母还是小写字母
                ret.append((char) (choice + random.nextInt(26)));
            } else { // 数字
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }
}
