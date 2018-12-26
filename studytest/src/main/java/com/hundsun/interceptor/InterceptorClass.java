package com.hundsun.interceptor;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/28 9:52
 */
public class InterceptorClass {

    public void before(){
        System.out.println("调用InterceptorClass的before方法");
    }

    public void after(){
        System.out.println("调用InterceptorClass的after方法");
    }
}
