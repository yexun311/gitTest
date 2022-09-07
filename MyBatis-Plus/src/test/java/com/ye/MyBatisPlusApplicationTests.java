package com.ye;

import com.ye.mapper.UserMapper;
import com.ye.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MyBatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    void myTest(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    void insertTest(){
        User user = new User();
        user.setId(0L);
        user.setName("peter");
        user.setAge(22);
        user.setEmail("131@peter.com");
        Integer result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    void deleteTest(){

    }

}
