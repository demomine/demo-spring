package com.lance.demo.spring.transaction;

import com.lance.demo.spring.TestBase;
import com.lance.demo.spring.config.SpringConfig;
import com.lance.demo.spring.dao.model.ClassPO;
import com.lance.demo.spring.dao.model.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perdonare on 2017/5/10.
 */
@Slf4j
public class TransactionDemoTest extends TestBase{
    @Autowired
    private TransactionDemo transactionDemo;
    @Autowired
    private PersistService persistService;

    private UserPO userPO;

    private ClassPO classPO;

    @Before
    public void init() {
        classPO = new ClassPO(1,1,"class_one");
        userPO = new UserPO(1,1,1,"lance",18);
    }
    @Test
    public void addUserDemo_required() throws Exception {
        try {
            transactionDemo.addUserDemo_required(classPO, userPO);
        } catch (RuntimeException re) {
            log.info("test exception ignore:{}",re.getMessage());
            re.printStackTrace();
        }
        ClassPO clazz = persistService.getClassPO(1);
        UserPO user = persistService.getUserPO(1);
        Assert.assertNotNull(clazz);
        Assert.assertNotNull(user);
    }

    @Test
    public void addUserDemo_required_new() throws Exception {
        try {
            transactionDemo.addUserDemo_required_new(classPO, userPO);
        } catch (RuntimeException re) {
            log.info("test exception ignore:{}",re.getMessage());
        }
        ClassPO clazz = persistService.getClassPO(1);
        UserPO user = persistService.getUserPO(1);
        Assert.assertNotNull(clazz);
        Assert.assertNull(user);
    }

    @Test
    public void addUserDemo_mandatory() throws Exception {
        try {
            transactionDemo.addUserDemo_mandatory(classPO, userPO);
        } catch (RuntimeException re) {
            log.info("test exception ignore:{}",re.getMessage());
        }
        ClassPO clazz = persistService.getClassPO(1);
        UserPO user = persistService.getUserPO(1);
        Assert.assertNotNull(clazz);
        Assert.assertNull(user);
    }

    @Test
    public void addUserDemo_nested() throws Exception {
        try {
            transactionDemo.addUserDemo_nested(classPO, userPO);
        } catch (RuntimeException re) {
            log.info("test exception ignore:{}",re.getMessage());
            re.printStackTrace();
        }
        ClassPO clazz = persistService.getClassPO(1);
        UserPO user = persistService.getUserPO(1);
        Assert.assertNotNull(clazz);
        Assert.assertNotNull(user);
    }

    @Test
    public void addUserDemo_support() throws Exception {
        try {
            transactionDemo.addUserDemo_support(classPO, userPO);
        } catch (RuntimeException re) {
            log.info("test exception ignore:{}",re.getMessage());
            re.printStackTrace();
        }
        ClassPO clazz = persistService.getClassPO(1);
        UserPO user = persistService.getUserPO(1);
        Assert.assertNotNull(clazz);
        Assert.assertNotNull(user);
    }

}