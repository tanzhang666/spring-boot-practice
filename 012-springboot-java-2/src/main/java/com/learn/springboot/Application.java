package com.learn.springboot;

import com.learn.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);//关闭启动banner
//        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        helloService.sayHello();
    }
}
