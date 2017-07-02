package com.lance.demo.spring.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by immerer on 2017/6/24.
 */
@Service
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        if (o instanceof UserModel) {
            UserModel userModel = (UserModel) o;
            if (userModel.getAge() < 0) {
                errors.rejectValue("age","negative value");
            }
        }
    }
}
