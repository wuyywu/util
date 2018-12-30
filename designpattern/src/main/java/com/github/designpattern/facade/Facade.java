package com.github.designpattern.facade;

/**
 * 外观类，它需要了解所有的子系统的方法或属性，进行组合，以备外界调用
 *
 * @author wuyun
 * @date 2018/12/30 17:19
 */
public class Facade {

    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    SubSystemFour subSystemFour;

    public Facade() {
        this.subSystemOne = new SubSystemOne();
        this.subSystemTwo = new SubSystemTwo();
        this.subSystemThree = new SubSystemThree();
        this.subSystemFour = new SubSystemFour();
    }

    public void methodA(){
        System.out.println("方法组A");

        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
        subSystemFour.methodFour();
    }

    public void methodB(){
        System.out.println("方法组B");

        subSystemThree.methodThree();
        subSystemFour.methodFour();
    }
}
