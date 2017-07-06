package com.lance.demo.spring.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
@Service
public class AopPointcut extends StaticMethodMatcherPointcut{
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().equals("hello");
    }
}
