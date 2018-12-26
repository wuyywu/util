package com.github.designpattern.decorator;

/**
 * ConcreteDecoratorC是具体装饰对象，起到给Component添加职责的功能
 *
 * @author wuyun
 * @date 2018/12/20 14:17
 */
public class ConcreteDecoratorC extends Decorator {

    @Override
    public void operation() {
        super.operation();
        System.out.println("C没有特殊行为 " + "具体装饰对象C的操作");
    }
}
