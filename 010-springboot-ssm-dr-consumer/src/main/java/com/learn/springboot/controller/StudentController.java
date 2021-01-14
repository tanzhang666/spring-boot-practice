package com.learn.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0")
    private StudentService studentService;

    @RequestMapping("/students/{id}")
    public String getStudent(Model model, @PathVariable Long id){
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }
}
