package com.ye.controller;

import com.ye.common.result.Result;
import com.ye.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/setUser")
    public Result<String> set(@RequestBody User user){
        user.setIsDeleted(0);
        redisTemplate.opsForValue().set(user.getId().toString(), user);
        return null;
    }

    @GetMapping("/getUserById")
    public Result<User> get(@RequestParam Integer id){
        //return new Result<User>(200, "success", (User)redisTemplate.opsForValue().get(id.toString()));
        return null;
    }

}
