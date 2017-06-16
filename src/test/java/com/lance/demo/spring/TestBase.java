package com.lance.demo.spring;

import com.lance.demo.spring.config.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.*;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by perdonare on 2017/5/10.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@Configuration
// @Transactional
public class TestBase {
    @Bean
    @Primary
    TaskExecutor taskExecutor() {
        return new SyncTaskExecutor();
    }
}
