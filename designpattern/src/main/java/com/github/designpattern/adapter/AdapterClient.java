package com.github.designpattern.adapter;

/**
 * 适配器客户端
 *
 * @author wuyun
 * @date 2019/1/1 18:18
 */
public class AdapterClient {

    public static void main(String[] args) {
        Target target;

        target = new Adapter();
        target.request();
    }
}
