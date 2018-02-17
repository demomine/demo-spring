package com.lance.demo.spring.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/6/14.
 */
@Slf4j
//@Service
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {
    /**
     * 错误的示例,无法获取 beanCycleDemo 的属性 因为此时  beanCycleDemo还未被实例化
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("beanCycleDemo");
        if (beanDefinition != null) {
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (propertyValues.contains("name")) {
                propertyValues.addPropertyValue("name","lance");
            }
        }
    }
}
