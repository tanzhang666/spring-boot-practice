package com.learn.springboot;

import com.learn.springboot.service.HelloService;
import com.learn.springboot.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        HelloService helloService = (HelloService) run.getBean("helloServiceImpl");
        helloService.sayHello();
    }

}
