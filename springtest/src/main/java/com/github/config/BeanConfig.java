package com.github.config;

import com.github.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/10/28 18:53
 */
@Configuration
public class BeanConfig {

    @Bean(name = "user2")
    public User user(){
        return new User("李四", "18", "女");
    }
}
