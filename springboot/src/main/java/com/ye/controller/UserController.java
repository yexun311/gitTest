package com.ye.controller;

import com.ye.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    public String set(@RequestBody User user){
        redisTemplate.opsForValue().set("user", user);
        redisTemplate.opsForValue().set("abc", 123);
        return "success";
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key){
        return redisTemplate.opsForValue().get(key);
    }
}
