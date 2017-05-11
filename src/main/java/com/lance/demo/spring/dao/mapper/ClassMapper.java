package com.lance.demo.spring.dao.mapper;

import com.lance.demo.spring.dao.model.ClassPO;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassPO record);

    int insertSelective(ClassPO record);

    ClassPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassPO record);

    int updateByPrimaryKey(ClassPO record);
}