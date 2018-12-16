package com.github.designpattern.strategy;

/**
 * 具体算法A
 *
 * @author wuyun
 * @date 2018/12/16 13:01
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A");
    }
}
