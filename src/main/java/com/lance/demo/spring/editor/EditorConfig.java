package com.lance.demo.spring.editor;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by immerer on 2017/6/25.
 */
@Configuration
public class EditorConfig {
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
        map.put(User.class,UserEditor.class);
        customEditorConfigurer.setCustomEditors(map);
        return customEditorConfigurer;
    }
}
