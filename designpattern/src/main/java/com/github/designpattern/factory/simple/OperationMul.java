package com.github.designpattern.factory.simple;

/**
 * 乘法操作
 *
 * @author wuyun
 * @date 2018/12/16 12:37
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return numberA * numberB;
    }
}
