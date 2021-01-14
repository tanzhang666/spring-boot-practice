package com.learn.springboot.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Reference(version = "1.0",interfaceClass = StudentService.class,check = false)
    private StudentService studentService;

    @RequestMapping("/students/{id}")
    public @ResponseBody Student queryStudentById(Long id){
        return studentService.queryStudentById(id);
    }

}
