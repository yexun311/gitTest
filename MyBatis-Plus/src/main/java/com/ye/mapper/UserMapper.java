package com.ye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ye.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作都编写完成了，不用像以前一样配置一大堆文件

    List<User> selectByAge(int age);
}
