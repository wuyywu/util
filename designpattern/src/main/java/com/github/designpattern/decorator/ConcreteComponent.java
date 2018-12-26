package com.github.designpattern.decorator;

/**
 * ConcreteComponent是定义一个具体的对象，也可以给这个对象添加一些职责
 *
 * @author wuyun
 * @date 2018/12/20 14:13
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
