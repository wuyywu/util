package com.github.designpattern.factory.simple;

/**
 * 计算器
 *
 * @author wuyun
 * @date 2018/12/16 12:52
 */
public class Calculator {

    /**
     * 客户端代码简单
     * @param args
     * @return
     */
    public static void main(String[] args) {
        char operation = '+';
        Operation oper;
        oper = OperationFactory.createOperation(operation);
        oper.numberA = 1.2;
        oper.numberB = 3.5;
        System.out.println(oper.getResult());

    }
}
