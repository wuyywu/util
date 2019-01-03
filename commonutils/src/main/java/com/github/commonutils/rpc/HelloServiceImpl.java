package com.github.commonutils.rpc;

/**
 * HelloServiceImpl
 *
 * @author wuyun
 * @date 2019/1/2 16:03
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
