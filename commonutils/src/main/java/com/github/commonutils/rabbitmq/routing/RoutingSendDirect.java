package com.github.commonutils.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/2 20:35
 */
public class RoutingSendDirect {

    private static final String EXCHANGE_NAME = "direct_logs";
    /**
     * 路由关键字
     */
    private static final String[] routingKeys = new String[]{"info" ,"warning", "error"};
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("wuyun");
        factory.setPassword("wuyun");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        //注意是direct
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        //发送信息
        for (String routingKey:routingKeys){
            String message = "RoutingSendDirect Send the message level:" + routingKey;
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,message.getBytes());
            System.out.println("RoutingSendDirect Send"+routingKey +"':'" + message);
        }
        channel.close();
        connection.close();
    }
}
