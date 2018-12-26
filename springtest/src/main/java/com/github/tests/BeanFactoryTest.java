package com.github.tests;

import com.github.model.User;
import com.github.utils.SpringBeanFactoryUtil;
import com.github.utils.SpringUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * XmlBeanFactory能实例化@Component，不能实例化@Bean
 *
 * @author wuyun
 * @date 2018/10/24 19:56
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        beanFactory.toString();
        User user1 = beanFactory.getBean("user3", User.class);
        User user2 = beanFactory.getBean("user2", User.class);


        //手动向spring容器中注册BeanDefinition
        BeanDefinition listenBeanDefinition = new RootBeanDefinition("com.github.model.User");
        beanFactory.registerBeanDefinition("User", listenBeanDefinition);

        User temp = beanFactory.getBean("User", User.class);


        System.out.println(user1.toString());
        System.out.println(user2.toString());

        System.out.println(temp.toString());

        System.out.println(SpringUtil.getApplicationContext());
        System.out.println(SpringBeanFactoryUtil.getBeanFactory());

        for (String beanName: beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

}
