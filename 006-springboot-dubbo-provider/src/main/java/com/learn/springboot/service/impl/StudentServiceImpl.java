package com.learn.springboot.service.impl;

import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student queryStudentById(Long id) {
        Student student = new Student();
        student.setId(id);
        student.setName("test");
        student.setAge(18);
        return student;
    }
}
