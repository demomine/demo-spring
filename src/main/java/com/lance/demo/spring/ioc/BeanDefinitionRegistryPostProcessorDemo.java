package com.lance.demo.spring.ioc;

import com.lance.demo.spring.config.CustomBeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class BeanDefinitionRegistryPostProcessorDemo {
    @Autowired
    private CustomBeanDefinitionRegistryPostProcessor.Hello hello;


    public void demo() {
        hello.setHello("hello world");
        System.out.println(hello.getHello());
    }
}
