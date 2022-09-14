package com.ye;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ye.mapper.UserMapper;
import com.ye.pojo.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.*;

@SpringBootTest
class MyBatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    void selectTest(){
        System.out.println("-------------selectList method test-----------------");
        // 参数是一个mapper，条件构造器，这里不用，填null
        // 查询所有用户
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        System.out.println("-------------selectById method test-----------------");
        User user = userMapper.selectById(1L);
        System.out.println(user);
        System.out.println("-------------selectBatchIds method test-----------------");
        userList = userMapper.selectBatchIds(Lists.newArrayList(1L,2L,5L));
        System.out.println(userList);
        System.out.println("-------------selectByMap method test-----------------");
        Map<String,Object> map = new HashMap<>();
        // 自定义查询条件
        map.put("name","jack");
        map.put("age",20);
        userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }
    @Test
    void insertTest(){
        System.out.println("-------------insert method test-----------------");
        User user = new User();
        user.setId(0L);
        user.setName("peter");
        user.setAge(22);
        user.setEmail("131@peter.com");
        int result = userMapper.insert(user);
        if (result == 1)
            System.out.println("insert success");
    }

    @Test
    void deleteTest(){
        System.out.println("-------------deleteById method test-----------------");
        int result = userMapper.deleteById(9L);
        if (result == 1)
            System.out.println("delete success");
    }

    @Test
    void updateTest(){
        System.out.println("-------------update method test-----------------");
        User user = new User(10L,"like",23,"111@like.com");
        int result = userMapper.updateById(user);
        if (result == 1)
            System.out.println("update success");
    }


    @Test
    void selectTest1(){
        System.out.println("-----查询name不为null，邮箱不为null，年龄大于等于21的用户-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name");
        wrapper.isNotNull("email");
        wrapper.ge("age",21);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void selectTest2(){
        System.out.println("-----查询name为jack的用户-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","jack");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void selectTest3(){
        System.out.println("-----查询年龄在21~22岁之间的用户-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",21,22);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void selectTest4(){
        System.out.println("-----模糊查询-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","ac");

        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);

        List<Map<String,Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void selectTest0(){
        System.out.println("-----查询email有13的用户-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email","13");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void myTest1(){

    }
}
