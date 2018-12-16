package com.github.designpattern.strategy;

/**
 * 客户端调用
 *
 * @author wuyun
 * @date 2018/12/16 13:04
 */
public class Client {
    /**
     * 策略模式思想是针对一组算法，将每一种算法都封装到具有共同接口的独立的类中，从而是它们可以相互替换。
     * 策略模式的最大特点是使得算法可以在不影响客户端的情况下发生变化，从而改变不同的功能。
     * TreeSet使用了策略模式
     */

    /**
     * 策略模式用来封装变化，当算法变化时，客户端的代码不会变动
     * 可以将new具体算法对象放到Context里，Context的构造器改造String入参，将简单工厂模式与策略模式结合
     * 客户端就不用关心具体算法了
     * @param args
     * @return
     */
    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
