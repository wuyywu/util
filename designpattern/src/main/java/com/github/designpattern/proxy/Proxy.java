package com.github.designpattern.proxy;

/**
 * 代理类
 *
 * @author wuyun
 * @date 2018/12/29 16:18
 */
public class Proxy implements Subject {

    /**
     * 保存一个引用，使得代理可以访问真实实体
     */
    private Subject subject;

    public Proxy() {
        subject = new RealSubject();
    }

    @Override
    public void request() {
        subject.request();
    }
}
