package com.learn.springboot.service;

import com.learn.springboot.model.Student;

public interface StudentService {

    Student queryById(Long id);
}
