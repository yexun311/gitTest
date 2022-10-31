package com.ye.controller;

import com.ye.common.result.Result;
import com.ye.common.result.ResultSet;
import com.ye.model.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/class")
    public ResultSet<UserEntity> classJson(){
        UserEntity userEntity = new UserEntity(123L,"xiaoliu","332");
        return null;
    }

    @RequestMapping("/list")
    public ResultSet<List<UserEntity>> listJson(){
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity(1234L,"xiaobei","566"));
        userEntityList.add(new UserEntity(5678L,"xiaojiang","788"));
        return Result.success(userEntityList);
    }

    @RequestMapping("/map")
    public ResultSet<Map<String,Object>> mapJson() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("1", new UserEntity(1L, "yi", "111"));
        userMap.put("2", new UserEntity(2L, "er", "222"));
        return Result.success(userMap);
    }
}
