package com.github.designpattern.factory.method;

import com.github.designpattern.factory.simple.Operation;

/**
 * 工厂接口
 *
 * @author wuyun
 * @date 2018/12/29 16:37
 */
public interface IFactory {

    Operation createOperation();
}
