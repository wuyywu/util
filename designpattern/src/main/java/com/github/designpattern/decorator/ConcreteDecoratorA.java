package com.github.designpattern.decorator;

/**
 * ConcreteDecoratorA是具体装饰对象，起到给Component添加职责的功能
 *
 * @author wuyun
 * @date 2018/12/20 14:17
 */
public class ConcreteDecoratorA extends Decorator {

    private String addedState;

    @Override
    public void operation() {
        // 首先运行原Component的operation()，再执行本类的功能，如addedState，相当于对原Component进行了装饰
        super.operation();
        addedState = "A中的new state ";
        System.out.println(addedState + "具体装饰对象A的操作");
    }
}
