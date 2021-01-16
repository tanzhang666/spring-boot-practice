package com.learn.springboot.config;

import com.learn.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截user下的所有请求
        String[] addPathPatterns={"/user/**"};
//        String[] addPathPatterns={"/user/center"};
        //排除以下路径
        String[] excludePathPattern={"/user/out","/user/login","/user/error"};
//        String[] excludePathPattern={};

        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns(addPathPatterns).
                excludePathPatterns(excludePathPattern);
    }
}
