package com.lance.demo.spring.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by perdonare on 2017/6/14.
 */
@Slf4j
@Service
public class BeanRecycleDemo implements InitializingBean,DisposableBean, BeanPostProcessor {
    @Setter
    @Getter
    private String name;
    @Override
    public void destroy() throws Exception {
       log.info("BeanCycleDemo destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("BeanCycleDemo  start");
    }

    @PostConstruct
    public void init() throws Exception {
        log.info("BeanCycleDemo  init");

    }

    @PreDestroy
    public void stop() throws Exception {
        log.info("BeanCycleDemo  stop");

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanCycleDemo before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanCycleDemo after");
        return bean;
    }


}
