package com.lance.demo.spring.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by immerer on 2017/6/25.
 */
@Data
public class User {
    private String name;

    private int age;
}
