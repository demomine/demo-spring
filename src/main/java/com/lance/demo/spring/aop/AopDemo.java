package com.lance.demo.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j@Service
public class AopDemo implements AopDemoInterface{

    @Override
    public void hello() {
        log.info("hello aop");
    }

    public void hello2() {
        log.info("hello aop 2");
    }
}
