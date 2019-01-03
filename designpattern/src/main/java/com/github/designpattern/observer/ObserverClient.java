package com.github.designpattern.observer;

/**
 * 观察者模式客户端代码
 *
 * @author wuyun
 * @date 2019/1/1 16:58
 */
public class ObserverClient {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();

        concreteSubject.attach(new ConcreteObserver(concreteSubject, "X"));
        concreteSubject.attach(new ConcreteObserver(concreteSubject, "Y"));
        concreteSubject.attach(new ConcreteObserver(concreteSubject, "Z"));

        concreteSubject.setSubjectState("ABC");
        concreteSubject.notifyObserver();

    }
}
