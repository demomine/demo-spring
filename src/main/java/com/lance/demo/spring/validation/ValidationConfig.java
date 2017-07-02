package com.lance.demo.spring.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Created by immerer on 2017/6/24.
 */
@Configuration
public class ValidationConfig {
    @Bean
    public UserModel userModel1() {
        return new UserModel(null, 20);
    }

    @Bean
    public UserModel userModel2() {
        return new UserModel("lance", -1);
    }
}
