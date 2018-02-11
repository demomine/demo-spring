package com.lance.demo.spring.aop;

import org.springframework.stereotype.Service;

/**
 * Created by immerer on 2017/7/2.
 */
@Service
public class AopDemo {
    public String hello(String string) {
        return string;
    }
}
