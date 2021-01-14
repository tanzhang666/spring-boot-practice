package com.learn.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.springboot.mapper.StudentMapper;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass = StudentService.class,version = "1.0")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Student queryStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student saveStudent(Student student) {
        String name = student.getName();
        if (name ==null){
            return null;
        }
        if(studentMapper.selectByName(name)!=null){
            return null;
        }
        studentMapper.insertSelective(student);
        Student byName = studentMapper.selectByName(name);
        redisTemplate.opsForHash().put("student"+byName.getId(),"name",byName.getName());
        redisTemplate.opsForHash().put("student"+byName.getId(),"age",byName.getAge());
        return byName;
    }
}
