package com.lance.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by perdonare on 2017/5/10.
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement/*(mode = AdviceMode.ASPECTJ)*/
@ComponentScan(basePackages = {"com.lance.demo.spring"})
public class SpringConfig {
}
