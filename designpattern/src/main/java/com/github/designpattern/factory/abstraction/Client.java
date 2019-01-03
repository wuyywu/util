package com.github.designpattern.factory.abstraction;

import com.github.designpattern.factory.simple.Operation;

/**
 * 客户端
 *
 * @author wuyun
 * @date 2019/1/1 17:33
 */
public class Client {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Operation operation = OperationFactory.createOperation("/");

        operation.numberA = 7;
        operation.numberB = 8;

        System.out.println(operation.getResult());
    }
}
