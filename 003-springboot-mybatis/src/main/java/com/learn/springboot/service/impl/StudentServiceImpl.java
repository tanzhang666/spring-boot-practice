package com.learn.springboot.service.impl;

import com.learn.springboot.mapper.StudentMapper;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryById(long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public Student updateById(long id, String name, Integer age) {
        Student oldStudent = studentMapper.selectByPrimaryKey(id);
        if(oldStudent==null){
            return null;
        }
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        studentMapper.updateByPrimaryKeySelective(student);
        return student;
    }

}
