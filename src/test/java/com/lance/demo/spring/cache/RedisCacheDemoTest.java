package com.lance.demo.spring.cache;

import com.lance.demo.spring.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/5/11.
 */
public class RedisCacheDemoTest extends TestBase{
    @Autowired
    private RedisCacheDemo redisCacheDemo;
    @Test
    public void getUser_list() throws Exception {
        List<User> users = redisCacheDemo.getUser_list();
        assertEquals(users.size(),2);
        List<User> cachedUsers = redisCacheDemo.getUser_list();
        assertEquals(cachedUsers.size(),2);
    }

    @Test
    public void getUser_list_param() throws Exception {
        List<User> users = redisCacheDemo.getUser_list_param("lance");
        assertEquals(users.size(),2);
        List<User> cachedUsers = redisCacheDemo.getUser_list_param("lance");
        assertEquals(cachedUsers.size(),2);
    }

    @Test
    public void getUser_list_empty() throws Exception {
        List<User> users = redisCacheDemo.getUser_list_empty();
        assertEquals(users.size(),0);
        List<User> cachedUsers = redisCacheDemo.getUser_list_empty();
        redisCacheDemo.getUser_list_empty();
        assertEquals(cachedUsers.size(),0);
    }

    @Test
    public void getUser_list_empty_condition() throws Exception {
        List<User> users = redisCacheDemo.getUser_list_empty_no_cache();
        //assertEquals(users.size(),0);
        List<User> cachedUsers = redisCacheDemo.getUser_list_empty_no_cache();
        //assertEquals(cachedUsers.size(),0);
    }

}