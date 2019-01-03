package com.github.commonutils.rabbitmq.springrabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/2 21:09
 */
public class ProducerMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("amqp-context.xml");
        AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");
        for (int i = 0; i < 20; i++) {
            System.out.println("Sending message #" + i);
            Spittle spittle = new Spittle((long) i,  "Hello world (" + i + ")", new Date());
            template.convertAndSend(spittle);
            Thread.sleep(5000);
        }
        System.out.println("Done!");
    }
}
