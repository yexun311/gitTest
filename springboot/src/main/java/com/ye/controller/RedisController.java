package com.ye.controller;

import com.ye.common.result.HttpStatusEnum;
import com.ye.common.result.HttpStatusHandler;
import com.ye.common.result.Result;
import com.ye.common.result.ResultSet;
import com.ye.exception.FailException;
import com.ye.model.entity.UserEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/setUser")
    public ResultSet<Void> set(@RequestBody UserEntity userEntity){
        if ("eee".equals(userEntity.getAccount()))
            throw new FailException("拉萨达瓦低洼地纷纷撒");
        userEntity.setIsDeleted(0);
        redisTemplate.opsForValue().set(userEntity.getId().toString(), userEntity);
        return Result.success(HttpStatusEnum.SUCCESS, "操作成功");
    }

    @GetMapping("/getUserById")
    public ResultSet<UserEntity> get(@RequestParam Integer id){
        return Result.success(HttpStatusEnum.SUCCESS, (UserEntity) redisTemplate.opsForValue().get(id.toString()));
    }

}
