package com.lance.demo.spring.web;

import com.lance.demo.spring.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebController.class,ModelAttributeController.class,RequestParamController.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
