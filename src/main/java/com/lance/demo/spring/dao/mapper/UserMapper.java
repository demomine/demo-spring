package com.lance.demo.spring.dao.mapper;

import com.lance.demo.spring.dao.model.UserPO;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}