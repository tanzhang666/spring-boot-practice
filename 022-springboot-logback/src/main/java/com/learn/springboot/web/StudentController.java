package com.learn.springboot.web;


import com.learn.springboot.model.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("students/{id}")
    public @ResponseBody Student queryById(@PathVariable Long id){

        log.trace("trace");
        log.debug("debug");
        log.info("查询指定id的用户");
        log.warn("warn");
        log.error("error");
        return studentService.queryById(id);
    }

}
