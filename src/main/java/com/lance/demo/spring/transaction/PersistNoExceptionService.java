package com.lance.demo.spring.transaction;

import com.lance.demo.spring.dao.mapper.ClassMapper;
import com.lance.demo.spring.dao.mapper.UserMapper;
import com.lance.demo.spring.dao.model.ClassPO;
import com.lance.demo.spring.dao.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perdonare on 2017/5/10.
 */
@Repository
public class PersistNoExceptionService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private UserMapper userMapper;


    @Transactional
    // @Transactional(propagation = Propagation.REQUIRED)
    public void addClassWithTx(ClassPO classPO) {
        classMapper.insert(classPO);
    }

    @Transactional
    // @Transactional(propagation = Propagation.MANDATORY)
    public void addUserWithMandatory(UserPO userPO) {
        userMapper.insert(userPO);
    }


    public ClassPO getClassPO(int id) {
        return classMapper.selectByPrimaryKey(id);
    }

    public UserPO getUserPO(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
