package com.lance.demo.spring;

import com.lance.demo.spring.config.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perdonare on 2017/5/10.
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
// @Transactional
public class TestBase {
}
