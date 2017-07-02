package com.lance.demo.spring.validation;

import com.lance.demo.spring.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by immerer on 2017/6/24.
 */
public class ValidationTest extends TestBase {
    @Autowired
    private ValidationDemo validationDemo;
    @Test
    public void valid() {

        BindingResult bindingResult = validationDemo.valid();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
    }
}
