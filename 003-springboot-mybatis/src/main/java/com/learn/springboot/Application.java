package com.learn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.learn.springboot.mapper")//开启扫描mapper接口的包以及子包
@EnableTransactionManagement//可加可不加 都会开启事务管理
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
