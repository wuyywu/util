package com.github.designpattern.adapter.demo2;

/**
 * 外籍中锋
 *
 * @author wuyun
 * @date 2019/5/21 14:17
 */
public class ForeignCenter {

    private String name;

    public void jinGong() {
        System.out.println(String.format("外籍中锋{%s}进攻", name));
    }

    public void fangShou() {
        System.out.println(String.format("外籍中锋{%s}防守", name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
