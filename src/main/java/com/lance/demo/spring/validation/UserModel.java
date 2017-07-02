package com.lance.demo.spring.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by immerer on 2017/6/24.
 */
@Data@AllArgsConstructor
public class UserModel {
    private String name;

    private int age;
}
