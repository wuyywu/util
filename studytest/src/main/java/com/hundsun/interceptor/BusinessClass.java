package com.hundsun.interceptor;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/28 9:50
 */
public class BusinessClass implements BusinessFacade {
    @Override
    public void doSomething() {
        System.out.println("调用BusinessClass的doSomething方法");
    }
}
