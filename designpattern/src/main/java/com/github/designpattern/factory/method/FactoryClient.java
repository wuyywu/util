package com.github.designpattern.factory.method;

import com.github.designpattern.factory.simple.Operation;

/**
 * 工厂方法客户端
 *
 * @author wuyun
 * @date 2018/12/29 16:46
 */
public class FactoryClient {

    public static void main(String[] args) {
        IFactory operFactory = new DivFactory();
        Operation operation = operFactory.createOperation();
        operation.numberA = 3.4;
        operation.numberB = 4.5;

        System.out.println(operation.getResult());
    }
}
