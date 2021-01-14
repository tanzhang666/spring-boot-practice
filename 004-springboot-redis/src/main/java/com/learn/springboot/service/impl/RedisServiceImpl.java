package com.learn.springboot.service.impl;

import com.learn.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public void putVal(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public String getStr(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
