package com.github.designpattern.factory.method;

import com.github.designpattern.factory.simple.Operation;
import com.github.designpattern.factory.simple.OperationAdd;

/**
 * 加法工厂
 *
 * @author wuyun
 * @date 2018/12/29 16:40
 */
public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
