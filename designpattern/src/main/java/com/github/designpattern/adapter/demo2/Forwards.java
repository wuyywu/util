package com.github.designpattern.adapter.demo2;

/**
 * 前锋
 *
 * @author wuyun
 * @date 2019/5/21 14:17
 */
public class Forwards extends Player {

    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(String.format("前锋{%s}进攻", name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("前锋{%s}防守", name));
    }
}
