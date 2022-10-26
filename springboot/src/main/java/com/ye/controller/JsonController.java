package com.ye.controller;

import com.ye.common.result.Result;
import com.ye.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/class")
    public Result<User> classJson(){
        User user = new User(123L,"xiaoliu","332");
        return null;
    }

    @RequestMapping("/list")
    public Result<List<User>> listJson(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1234L,"xiaobei","566"));
        userList.add(new User(5678L,"xiaojiang","788"));
        return null;
    }

    @RequestMapping("/map")
    public Result<Map<String,Object>> mapJson() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("1", new User(1L, "yi", "111"));
        userMap.put("2", new User(2L, "er", "222"));
        return null;
    }
}
