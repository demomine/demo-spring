package com.lance.demo.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/6/14.
 */
//@Aspect
@Slf4j
//@Service
public class BeanPostProcessorAspect {
    @Pointcut("execution(* com.lance.demo.spring.ioc.BeanPostProcessorDemo.*(..))")
    private void aspectBean() {}

    @Around("aspectBean()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aspect start");
        Object o =  proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        log.info("aspect finish");
        return o;
    }
}
