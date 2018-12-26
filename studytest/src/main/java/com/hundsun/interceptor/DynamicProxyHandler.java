package com.hundsun.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/28 9:54
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object business;

    private InterceptorClass interceptor = new InterceptorClass();

    public Object bind(Object business){
        this.business = business;

        return Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        interceptor.before();
        result = method.invoke(business, args);
        interceptor.after();
        return result;
    }
}
