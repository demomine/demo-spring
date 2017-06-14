package com.lance.demo.spring.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by perdonare on 2017/6/14.
 */
@Slf4j
public class BeanConfigDemo {
    public void init() throws Exception {
        log.info("BeanConfigDemo init");
    }

    public void close() throws Exception {
        log.info("BeanConfigDemo close");
    }
}
