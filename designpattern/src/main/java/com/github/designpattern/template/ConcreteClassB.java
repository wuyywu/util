package com.github.designpattern.template;

/**
 * 具体类B
 *
 * @author wuyun
 * @date 2018/12/29 17:54
 */
public class ConcreteClassB extends AbstractTemplate {
    @Override
    public void primitiveOperation1() {
        System.out.println("具体类B的方法1实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类B的方法2实现");
    }

}
