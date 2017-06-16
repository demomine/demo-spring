package com.lance.demo.spring.transaction;

import com.lance.demo.spring.dao.model.ClassPO;
import com.lance.demo.spring.dao.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perdonare on 2017/5/10.
 */
@Service
public class TransactionDemo {
    @Autowired
    private PersistService persistService;

    @Async
    public void addUserDemo(ClassPO classPO) {
        persistService.addClassWithTx(classPO);
    }

    @Transactional
    public void addUserDemo_required(ClassPO classPO,UserPO userPO) {
        persistService.addClassWithTx(classPO);
        persistService.addUserWithRequired(userPO);
    }

    public void addUserDemo_required_new(ClassPO classPO,UserPO userPO) {
        persistService.addClassWithTx(classPO);
        persistService.addUserWithRequiredNew(userPO);
    }

    public void addUserDemo_mandatory(ClassPO classPO,UserPO userPO) {
        persistService.addClassWithoutTx(classPO);
        persistService.addUserWithMandatory(userPO);
    }

    public void addUserDemo_nested(ClassPO classPO,UserPO userPO) {
        persistService.addClassWithTx(classPO);
        persistService.addUserWithNested(userPO);
    }

    public void addUserDemo_support(ClassPO classPO,UserPO userPO) {
        persistService.addClassWithTx(classPO);
        persistService.addUserWithSupport(userPO);
    }

}
