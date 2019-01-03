package com.github.designpattern.state;

/**
 * 抽象状态类
 *
 * @author wuyun
 * @date 2019/1/1 17:48
 */
public abstract class State {

    public abstract void handle(Context context);
}

class ConcreteStateA extends State{

    @Override
    public void handle(Context context) {
        System.out.println("现在是状态A");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        System.out.println("现在是在状态B");
        context.setState(new ConcreteStateC());
    }
}

class ConcreteStateC extends State {
    @Override
    public void handle(Context context) {
        System.out.println("现在是在状态C");
        context.setState(new ConcreteStateA());
    }
}