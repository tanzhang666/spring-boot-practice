package com.learn.springboot.service;

public interface RedisService {
    void putVal(String key, String value);

    String getStr(String key);
}
