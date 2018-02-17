package com.lance.demo.spring.ioc;

import com.lance.demo.spring.App;
import com.lance.demo.spring.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class})
public class BeanDefinitionRegistryPostProcessorDemoTest{
    @Autowired
    private BeanDefinitionRegistryPostProcessorDemo demo;

    @Test
    public void demo() {
        demo.demo();
    }
}