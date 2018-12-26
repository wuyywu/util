package com.github.tests;

import com.github.model.User;
import com.github.utils.SpringBeanFactoryUtil;
import com.github.utils.SpringUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/10/27 14:05
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = applicationContext.getBean("user3", User.class);
        User user1 = applicationContext.getBean("user2", User.class);


        System.out.println(user2.toString());
        System.out.println(user2.toString());

        System.out.println(SpringUtil.getApplicationContext());
        System.out.println(SpringBeanFactoryUtil.getBeanFactory());


    }
}
