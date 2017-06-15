package com.lance.demo.spring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created by perdonare on 2017/6/15.
 */
@Data
public class EventModel{
    private String name;
    private int age;
    public EventModel(Object source, String name, int age) {
        //super(source);
        this.name = name;
        this.age = age;
    }
}
