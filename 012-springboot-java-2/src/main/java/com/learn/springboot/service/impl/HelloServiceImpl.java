package com.learn.springboot.service.impl;


import com.learn.springboot.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(){
        System.out.println("hello");
    }
}
