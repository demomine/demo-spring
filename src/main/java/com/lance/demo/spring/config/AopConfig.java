package com.lance.demo.spring.config;

import com.lance.demo.spring.aop.AopDemo;
import com.lance.demo.spring.aop.AopDemoInterface;
import com.lance.demo.spring.aop.AopInterceptor;
import com.lance.demo.spring.aop.AopPointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    // @Bean@Primary
    public ProxyFactoryBean proxyFactoryBean(AopDemo aopDemo,AopInterceptor aopInterceptor) throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //proxyFactoryBean.setProxyInterfaces(new Class[]{AopDemoInterface.class});//代理的接口
        /*proxyFactoryBean.setInterfaces();
        proxyFactoryBean.setTargetName();//代理的类
        proxyFactoryBean.setProxyTargetClass();
        proxyFactoryBean.setFrozen();
        proxyFactoryBean.setSingleton();
        proxyFactoryBean.setExposeProxy();
        proxyFactoryBean.setPreFiltered();
        proxyFactoryBean.setOptimize();

        proxyFactoryBean.setTargetSource();
        proxyFactoryBean.setAutodetectInterfaces();
        proxyFactoryBean.setAdvisorAdapterRegistry();*/
        proxyFactoryBean.setTarget(aopDemo);
        // proxyFactoryBean.setProxyInterfaces(new Class[]{AopDemoInterface.class});//代理的接口
        proxyFactoryBean.addAdvice(aopInterceptor);
        proxyFactoryBean.setProxyTargetClass(true);
        return proxyFactoryBean;
    }

    @Bean@Primary
    public ProxyFactoryBean proxyFactoryBean(AopDemo aopDemo,AopInterceptor aopInterceptor, AopPointcut aopPointcut) throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(aopDemo);
        proxyFactoryBean.addAdvisor(new DefaultPointcutAdvisor(aopPointcut,aopInterceptor));
        proxyFactoryBean.setProxyTargetClass(true);
        return proxyFactoryBean;
    }

    //@Bean
    public PointcutAdvisor pointcutAdvisor2(AopInterceptor aopInterceptor, AopPointcut aopPointcut) {
        return new DefaultPointcutAdvisor(aopPointcut,aopInterceptor);
        // return new DefaultPointcutAdvisor(new AopInterceptor(), new AopPointcut());
    }

}
