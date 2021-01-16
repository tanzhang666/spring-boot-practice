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

    /**
     * 为提升系统性能 首先去redis中查询
     * 如存在 则直接返回
     * 如不存在 则去数据库中查询 然后再存在redis中
     * @param id
     * @return
     */
    @Override
    public Student queryById(Long id) {
        Student byRedis = queryByIdRedis(id);
        if(null!=byRedis){
            return byRedis;
        }
        Student byMySql = studentMapper.selectByPrimaryKey(id);
        saveToRedis(byMySql);
        return byMySql;
    }

    @Override
    public Student saveStudent(Student student) {
        String name = student.getName();
        if (null==name){
            return null;
        }
        if(studentMapper.selectByName(name)!=null){
            return null;
        }
        studentMapper.insertSelective(student);
        Student byName = studentMapper.selectByName(name);
        saveToRedis(byName);
        return byName;
    }

    public Student queryByIdRedis(Long id){
        Object name = redisTemplate.opsForHash().get("student" + id, "name");
        Object age = redisTemplate.opsForHash().get("student" + id, "age");
        if(null==name){
            return null;
        }
        Student student = new Student();
        student.setId(id);
        student.setName((String) name);
        student.setAge((Integer) age);
        return student;
    }

    public void saveToRedis(Student student) {
        redisTemplate.opsForHash().put("student"+ student.getId(),"name", student.getName());
        redisTemplate.opsForHash().put("student"+ student.getId(),"age", student.getAge());
    }
}
