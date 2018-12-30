package com.github.designpattern.builder;

/**
 *  指挥者类，用来指挥建造过程
 *
 * @author wuyun
 * @date 2018/12/30 20:46
 */
public class Director {

    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
