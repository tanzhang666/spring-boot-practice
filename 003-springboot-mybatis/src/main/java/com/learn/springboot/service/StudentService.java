package com.learn.springboot.service;

import com.learn.springboot.model.Student;

public interface StudentService {

    Student queryById(long id);

    Student updateById(long id, String name, Integer age);
}
