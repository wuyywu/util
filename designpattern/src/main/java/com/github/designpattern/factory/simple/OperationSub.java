package com.github.designpattern.factory.simple;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/16 12:37
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return numberA - numberB;
    }
}
