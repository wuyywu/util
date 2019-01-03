package com.github.commonutils.rpc;

/**
 * RpcProvider
 *
 * @author wuyun
 * @date 2019/1/2 16:04
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
