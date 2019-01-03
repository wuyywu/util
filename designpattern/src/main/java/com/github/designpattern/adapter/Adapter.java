package com.github.designpattern.adapter;

/**
 * 适配器类，通过在内部包装一个Adaptee对象，把原接口转换成目标接口
 *
 * @author wuyun
 * @date 2019/1/1 18:16
 */
public class Adapter extends Target {

    private Adaptee adaptee = new Adaptee();
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
