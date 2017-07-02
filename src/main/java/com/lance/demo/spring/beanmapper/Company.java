package com.lance.demo.spring.beanmapper;

import lombok.Data;

/**
 * Created by immerer on 2017/6/24.
 */
@Data
public class Company {
    private String name;

    private Employee employee;
}
