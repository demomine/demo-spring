package com.lance.demo.spring.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

/**
 * Created by immerer on 2017/6/24.
 */
@Service
public class ValidationDemo {
    @Autowired
    private UserModel userModel1;
    @Autowired
    private UserModel userModel2;
    @Autowired
    private UserValidator userValidator;

    public BindingResult valid() {
        BindingResult bindingResult = new BeanPropertyBindingResult(userModel1,"userModel1");
        userValidator.validate(userModel1,bindingResult);
        return bindingResult;
    }
}
