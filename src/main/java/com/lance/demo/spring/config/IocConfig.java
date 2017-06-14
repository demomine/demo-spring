package com.lance.demo.spring.config;

import com.lance.demo.spring.ioc.BeanConfigDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by perdonare on 2017/6/14.
 */
@Configuration
public class IocConfig {
    @Bean
    public BeanConfigDemo beanConfigDemo() {
        return new BeanConfigDemo();
    }
}
