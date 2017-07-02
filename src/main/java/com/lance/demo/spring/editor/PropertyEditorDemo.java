package com.lance.demo.spring.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by immerer on 2017/6/25.
 */
@Service
public class PropertyEditorDemo {
    @Value("lance,27")
    private User user;
    public User getUser() {
        return user;
    }
}
