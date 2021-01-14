package com.learn.springboot.web;

import com.learn.springboot.config.DevConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

//    @Value("test")
    @Value("${test}")//可直接写值也可引用配置文件里的值
    private String test;

    @Autowired
    private DevConfig devConfig;

    @RequestMapping(value = "/getValue",method = RequestMethod.GET)
    @ResponseBody
    public String getValue(){
        return test;
    }

    @RequestMapping(value = "/getObject",method = RequestMethod.GET)
    @ResponseBody
    public String getObject(){
        return devConfig.getA()+" "+devConfig.getB();
    }

}
