package com.github.designpattern.proxy;

/**
 * 真实实体类
 *
 * @author wuyun
 * @date 2018/12/29 16:16
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("真实对象的请求");
    }
}
