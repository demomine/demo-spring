package com.lance.demo.spring.cache;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by perdonare on 2017/5/11.
 */
@Service@Slf4j
public class RedisCacheDemo {
    @Cacheable(value = "users"/*,key = "users"*/)
    public List<User> getUser_list() {
        List<User> users = Lists.newArrayList(new User("name_1",20),new User("name_2",22));
        log.info("no cache ,create list");
        return users;
    }

    @Cacheable(value = "users"/*,key = "users"*/)
    public List<User> getUser_list_param(String param) {
        List<User> users = Lists.newArrayList(new User("name_1",20),new User("name_2",22));
        log.info("===========================\n no cache ,create list");
        return users;
    }

    @Cacheable(value = "users")
    public List<User> getUser_list_empty() {
        List<User> users = new ArrayList<>();
        log.info("==================================\n no cache ,create list");
        return users;
    }

    @Cacheable(value = "users",unless = "#result==null or #result.size() == 0")
    public List<User> getUser_list_empty_no_cache() {
        List<User> users = new ArrayList<>();
        // users.add(new User("a",32));
        log.info("==================================\n no cache ,create list");
        return users;
       /* log.info("==================================\n no cache ,create list");
        return null;*/
    }
}
