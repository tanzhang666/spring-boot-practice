package com.learn.springboot.web;

import com.learn.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/putVal")
    public @ResponseBody String putVal(@RequestParam String key, @RequestParam String value){
        redisService.putVal(key,value);
        return value;
    }

    @GetMapping("/getStr")
    public @ResponseBody String getStr(@RequestParam String key){
        return redisService.getStr(key);
    }
}
