package com.lance.demo.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * Created by immerer on 2017/7/2.
 */
@Aspect
@Service
@Slf4j
public class AopConfig {
    @AfterReturning(pointcut = "execution(* com.lance.demo.spring.aop.AopDemo.*(..))",returning="retVal")
    public void doubleString(String retVal) {
        log.info("==========:{}:{}",retVal,retVal);
    }
}
