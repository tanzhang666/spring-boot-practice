package com.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot项目启动入口类
@SpringBootApplication//spring boot核心注解 主要用于开启spring自动配置
public class Application {
    //jar包最后通过main方法运行
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    //项目代码必须在启动类所在的同一级或下一级目录
}
