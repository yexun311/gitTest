package com.ye.controller;

import com.ye.exception.FailException;
import com.ye.model.entity.UserEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/set")
    public String set(@RequestBody UserEntity userEntity){
        redisTemplate.opsForValue().set("user", userEntity);
        redisTemplate.opsForValue().set("abc", 123);
        return "success";
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key){
        return redisTemplate.opsForValue().get(key);
    }
}
