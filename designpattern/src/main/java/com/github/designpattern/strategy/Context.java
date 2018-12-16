package com.github.designpattern.strategy;

/**
 * 上下文
 *
 * @author wuyun
 * @date 2018/12/16 13:03
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 根据具体的策略对象，调用其算法的方法
     * @return
     */
    public void contextInterface() {
        strategy.algorithmInterface();
    }

}
