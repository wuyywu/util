package com.github.designpattern.proxy;

/**
 * 代理客户端
 *
 * @author wuyun
 * @date 2018/12/29 16:26
 */
public class ProxyClient {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
