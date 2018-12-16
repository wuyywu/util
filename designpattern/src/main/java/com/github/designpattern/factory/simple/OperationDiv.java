package com.github.designpattern.factory.simple;

import com.github.commonutils.exception.BusinessException;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/16 12:38
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (numberB == 0){
            throw new BusinessException("除数不能为0");
        }
        return numberA / numberB;
    }
}
