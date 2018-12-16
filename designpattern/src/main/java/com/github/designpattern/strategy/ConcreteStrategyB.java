package com.github.designpattern.strategy;

/**
 * 算法B
 *
 * @author wuyun
 * @date 2018/12/16 13:02
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法B");
    }
}
