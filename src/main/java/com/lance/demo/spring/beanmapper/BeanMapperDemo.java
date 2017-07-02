package com.lance.demo.spring.beanmapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.stereotype.Service;

/**
 * Created by immerer on 2017/6/24.
 */
@Service
public class BeanMapperDemo {
    public String map() {
        BeanWrapper beanWrapperEmp = new BeanWrapperImpl(new Employee());
        beanWrapperEmp.setPropertyValue(new PropertyValue("name", "emp"));

        BeanWrapper beanWrapperCompany = new BeanWrapperImpl(new Company());
        beanWrapperCompany.setPropertyValue("name", "lance");
        beanWrapperCompany.setPropertyValue("employee", beanWrapperEmp.getWrappedInstance());

        return (String) beanWrapperCompany.getPropertyValue("employee.name");
    }
}
