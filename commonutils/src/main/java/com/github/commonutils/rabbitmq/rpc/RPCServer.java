//package com.github.commonutils.rabbitmq.rpc;
//
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * https://www.cnblogs.com/LipeiNet/p/5980802.html
// *
// * @author wuyun
// * @date 2019/1/2 20:50
// */
//public class RPCServer {
//    private static final String RPC_QUEUE_NAME = "rpc_queue";
//
//    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        factory.setUsername("wuyun");
//        factory.setPassword("wuyun");
//        factory.setPort(5672);
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
//        channel.basicQos(1);
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        channel.basicConsume(RPC_QUEUE_NAME, false, consumer);
//
//        System.out.println("RPCServer Awating RPC request");
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            BasicProperties props = delivery.getProperties();
//            AMQP.BasicProperties replyProps = new AMQP.BasicProperties.Builder().
//                    correlationId(props.getCorrelationId()).build();
//
//            String message = new String(delivery.getBody(), "UTF-8");
//            int n = Integer.parseInt(message);
//
//            System.out.println("RPCServer fib(" + message + ")");
//            String response = "" + fib(n);
//            channel.basicPublish( "", props.getReplyTo(), replyProps, response.getBytes());
//            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
//        }
//    }
//
//    private static int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 1);
//    }
//
//
//}