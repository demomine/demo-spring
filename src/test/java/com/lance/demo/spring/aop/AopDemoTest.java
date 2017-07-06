package com.lance.demo.spring.aop;

import com.lance.demo.spring.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AopDemoTest extends TestBase{
    @Autowired
    private AopDemo aopDemo;
    @Test
    public void hello() throws Exception {
        aopDemo.hello();
    }

}