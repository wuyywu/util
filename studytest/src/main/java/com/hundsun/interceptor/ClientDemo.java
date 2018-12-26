package com.hundsun.interceptor;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/28 10:22
 */
public class ClientDemo {
    public static void main(String[] args) {
        DynamicProxyHandler handler = new DynamicProxyHandler();
        BusinessFacade businessFacade = new BusinessClass();
        BusinessFacade businessProxy = (BusinessFacade) handler.bind(businessFacade);
        businessProxy.doSomething();
    }
}
