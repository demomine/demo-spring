package com.lance.demo.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoIoc {
    @Autowired
    private DemoDepend demoDepend;
}
