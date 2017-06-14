package com.lance.demo.spring.ioc;

import com.lance.demo.spring.App;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/14.
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class})
public class BeanPostProcessorDemoTest {
    @Autowired
    private BeanPostProcessorDemo beanPostProcessorDemo;
    @Autowired
    private BeanCycleDemo beanCycleDemo;
    @Test
    public void aspect() throws Exception {
        //beanPostProcessorDemo.aspect();
        assertEquals("lance",beanCycleDemo.getName());
    }

}