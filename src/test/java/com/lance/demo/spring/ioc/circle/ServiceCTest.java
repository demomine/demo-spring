package com.lance.demo.spring.ioc.circle;

import com.lance.demo.spring.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class})
public class ServiceCTest {

    @Autowired
    private ServiceC serviceC;


    @Test
    public void hello() throws Exception {
        serviceC.hello();
    }

}