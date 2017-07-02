package com.lance.demo.spring.editor;

import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;

/**
 * Created by immerer on 2017/6/25.
 */
public class UserEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] infos = text.split(",");
        User user = new User();
        user.setName(infos[0].toUpperCase());
        user.setAge(Integer.valueOf(infos[1]));
        setValue(user);
    }

    @Override
    public String getJavaInitializationString() {
        return getValue()+"1111";
    }
}
