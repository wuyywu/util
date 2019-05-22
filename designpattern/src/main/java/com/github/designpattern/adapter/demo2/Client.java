package com.github.designpattern.adapter.demo2;

/**
 * 客户端代码
 *
 * @author wuyun
 * @date 2019/5/21 14:24
 */
public class Client {

    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attack();
        Player m = new Guards("麦克格雷迪");
        b.attack();

        Player y = new Translator("姚明");
        y.attack();
        y.defense();
    }
}
