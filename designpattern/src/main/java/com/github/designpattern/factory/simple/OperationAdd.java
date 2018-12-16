package com.github.designpattern.factory.simple;

/**
 * 加法操作
 *
 * @author wuyun
 * @date 2018/12/16 12:34
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return numberA + numberB;
    }
}
