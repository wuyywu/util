package com.github.designpattern.factory.method;

import com.github.designpattern.factory.simple.Operation;
import com.github.designpattern.factory.simple.OperationSub;

/**
 * 减法工厂
 *
 * @author wuyun
 * @date 2018/12/29 16:43
 */
public class SubFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
