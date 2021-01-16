package com.learn.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Reference(interfaceName = "com.learn.springboot.service.StudentService",check = false,version = "1.0")
    private StudentService studentService;

    /**
     * 为提升系统性能 首先去redis中查询
     * 如存在 则直接返回
     * 如不存在 则去数据库中查询 然后再存在redis中
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/students/{id}")
    public String getStudent(Model model, @PathVariable Long id){
        Student student = studentService.queryById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }


    @PostMapping("/students")
    public @ResponseBody Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
}
