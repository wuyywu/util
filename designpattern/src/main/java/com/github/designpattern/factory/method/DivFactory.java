package com.github.designpattern.factory.method;

import com.github.designpattern.factory.simple.Operation;
import com.github.designpattern.factory.simple.OperationDiv;

/**
 * 除法工厂
 *
 * @author wuyun
 * @date 2018/12/29 16:44
 */
public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
