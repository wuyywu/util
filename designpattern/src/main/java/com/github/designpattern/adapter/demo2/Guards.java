package com.github.designpattern.adapter.demo2;

/**
 * 后卫
 *
 * @author wuyun
 * @date 2019/5/21 14:17
 */
public class Guards extends Player {

    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(String.format("后卫{%s}进攻", name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("后卫{%s}防守", name));
    }
}
