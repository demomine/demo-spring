package com.lance.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by perdonare on 2017/5/11.
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class})
public class TestBase {

    @Test
    public void bootstrap() {
        log.info("framework start success");
    }
}
