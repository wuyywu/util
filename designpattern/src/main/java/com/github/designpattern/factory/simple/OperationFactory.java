package com.github.designpattern.factory.simple;

import com.github.commonutils.exception.BusinessException;

/**
 * 操作工厂
 *
 * @author wuyun
 * @date 2018/12/16 12:47
 */
public class OperationFactory {

    public static Operation createOperation(char operation){
        Operation oper = null;
        switch (operation){
            case '+':
                oper = new OperationAdd();
                break;
            case '-':
                oper = new OperationSub();
                break;
            case '*':
                oper = new OperationMul();
                break;
            case '/':
                oper = new OperationDiv();
                break;
            default:
                throw new BusinessException("不合法的操作符");
        }
        return oper;
    }
}
