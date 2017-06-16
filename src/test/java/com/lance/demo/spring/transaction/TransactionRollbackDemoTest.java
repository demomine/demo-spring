package com.lance.demo.spring.transaction;

import com.lance.demo.spring.TestBase;
import com.lance.demo.spring.dao.model.ClassPO;
import com.lance.demo.spring.dao.model.UserPO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perdonare on 2017/6/15.
 */
@Transactional
public class TransactionRollbackDemoTest extends TestBase {
    @Autowired
    private PersistNoExceptionService persistNoExceptionService;
    @Autowired
    private TransactionDemo transactionDemo;

    private UserPO userPO;

    private ClassPO classPO;

    @Before
    public void init() {
        classPO = new ClassPO(1,1,"class_one");
        userPO = new UserPO(1,1,1,"lance",18);
    }
    @Test
    public void rollback() throws Exception {
        persistNoExceptionService.addClassWithTx(classPO);
    }

    @Test
    public void async() throws Exception {
        transactionDemo.addUserDemo(classPO);
        Thread.sleep(10000);
    }
}
