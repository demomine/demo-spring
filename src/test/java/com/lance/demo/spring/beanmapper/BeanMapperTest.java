package com.lance.demo.spring.beanmapper;

import com.lance.demo.spring.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by immerer on 2017/6/25.
 */
public class BeanMapperTest extends TestBase{
    @Autowired
    private BeanMapperDemo beanMapperDemo;

    @Test
    public void map() {
        String empName = beanMapperDemo.map();
        Assert.assertEquals(empName,"emp");
    }
}
