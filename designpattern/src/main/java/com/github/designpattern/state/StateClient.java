package com.github.designpattern.state;

/**
 * 客户端：不断请求，不断更改状态
 *
 * @author wuyun
 * @date 2019/1/1 17:54
 */
public class StateClient {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());

        context.request();
        context.request();
        context.request();
        context.request();
        context.request();

    }
}
