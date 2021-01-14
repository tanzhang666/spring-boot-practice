package com.learn.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.stereotype.Component;

@Component
//之前在dubbo配置文件里配置的内容
@Service(interfaceClass = StudentService.class,version = "1.0",timeout = 20000)
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


