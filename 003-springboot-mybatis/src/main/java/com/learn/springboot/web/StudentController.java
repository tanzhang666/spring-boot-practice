package com.learn.springboot.web;

import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students/{id}")
    public Student queryById(@PathVariable long id) {
        return studentService.queryById(id);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public Student updateById(@PathVariable() long id, @RequestParam String name, @RequestParam Integer age) {
        return studentService.updateById(id, name, age);
    }

}
