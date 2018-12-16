package com.github.designpattern.factory.simple;

/**
 * 操作父类
 *
 * @author wuyun
 * @date 2018/12/16 12:31
 */
public abstract class Operation {

    public double numberA;
    public double numberB;

    public abstract double getResult();
}
