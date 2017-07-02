package com.lance.demo.spring.editor;

import com.lance.demo.spring.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by immerer on 2017/6/25.
 */
public class PropertyEditorDemoTest extends TestBase{
    @Autowired
    private PropertyEditorDemo propertyEditorDemo;
    @Test
    public void getUser() throws Exception {
        User user = propertyEditorDemo.getUser();
        assertEquals("LANCE",user.getName());
        assertEquals(27,user.getAge());
    }

}