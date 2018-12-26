package com.github.designpattern.decorator;

/**
 * ConcreteDecoratorB是具体装饰对象，起到给Component添加职责的功能
 *
 * @author wuyun
 * @date 2018/12/20 14:17
 */
public class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    public void addedBehavior() {
        System.out.print("B中的新增行为 ");
    }
}
