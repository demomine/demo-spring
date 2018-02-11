package com.lance.demo.spring.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class IOCService {
    @NotNull
    @Value("${test}")
    private String name;

    public void hello() {
        System.out.println(name);
    }
}
