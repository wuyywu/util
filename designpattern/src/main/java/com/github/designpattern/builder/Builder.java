package com.github.designpattern.builder;

/**
 * 抽象建造者类
 * 确定产品由2个部件partA，partB组成，并声明一个得到产品建造后的结果的方法
 *
 * @author wuyun
 * @date 2018/12/30 20:40
 */
public abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getBuildResult();
}
