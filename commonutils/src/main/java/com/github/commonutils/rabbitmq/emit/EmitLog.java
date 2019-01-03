package com.github.commonutils.rabbitmq.emit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/2 20:28
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("wuyun");
        factory.setPassword("wuyun");
        factory.setPort(5672);
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        //fanout表示分发，所有的消费者得到同样的队列信息
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //分发信息
        for (int i=0;i<5;i++){
            String message="Hello World"+i;
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
            System.out.println("EmitLog Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
