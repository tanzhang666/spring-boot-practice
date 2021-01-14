package com.learn.springboot.mapper;

import com.learn.springboot.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    Student selectByName(String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}