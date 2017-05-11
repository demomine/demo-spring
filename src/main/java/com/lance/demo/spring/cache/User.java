package com.lance.demo.spring.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by perdonare on 2017/5/11.
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class User implements Serializable{
    private String name;
    private int age;
}
