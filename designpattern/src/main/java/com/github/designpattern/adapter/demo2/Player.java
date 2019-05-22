package com.github.designpattern.adapter.demo2;

/**
 * 球员类
 *
 * @author wuyun
 * @date 2019/5/21 14:16
 */
public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void defense();
}
