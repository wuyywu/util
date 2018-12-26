package com.hundsun.test;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/8 17:28
 */
public class FormatTest {

    public static void main(String[] args) {
        Long no = new Long(4);
        //根据客户编号序列 mod 分表数 得到分库分表位
        int node = Math.floorMod(no.intValue(), 2);

        //分库分表字符串位数
        int num = 1 - 0 +1;
        //生成2位数的分库分表位
        String nodeString = String.format("%0" + num +"d", node);
        System.out.println(nodeString);
        System.out.println(Integer.parseInt(nodeString));
    }
}
