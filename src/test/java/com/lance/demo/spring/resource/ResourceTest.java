package com.lance.demo.spring.resource;

import com.lance.demo.spring.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by immerer on 2017/6/24.
 */
@Slf4j
public class ResourceTest extends TestBase {
    @Autowired
    private ResourceDemo resourceDemo;

    @Test
    public void resource1() throws IOException {
        String text = resourceDemo.resourceDemo1();
        Assert.assertEquals("resource test file",text);
    }

    @Test
    public void resource2() throws IOException {
        String text = resourceDemo.resourceDemo2();
        Assert.assertEquals("resource test file",text);
    }

    @Test
    public void resource3() throws IOException {
        String text = resourceDemo.resourceDemo3();
        Assert.assertEquals("resource test file",text);
    }

    @Test
    public void resource4() {
        try {
            resourceDemo.resourceDemo4();
        } catch (IOException e) {
            Assert.assertEquals("classpath*:Test.txt  not found",e.getMessage());
        }
    }

    @Test
    public void resource5() throws IOException {
        try {
            resourceDemo.resourceDemo5();
        } catch (IOException e) {
            Assert.assertEquals("classpath*:Test.txt  not found",e.getMessage());
        }
    }

    @Test
    public void resource6() throws IOException {
        String text = resourceDemo.resourceDemo6();
        log.info("===== content :{}",text.substring(0,100));
        Assert.assertTrue(text.length()>0);
    }

    @Test
    public void resource7() {
        try {
            resourceDemo.resourceDemo7();
        } catch (IOException e) {
            Assert.assertEquals("Connection refused: connect",e.getMessage());
        }
    }
}
