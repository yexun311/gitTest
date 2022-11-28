package com.ye;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ye.mapper.UserMapper;
import com.ye.pojo.User;
import com.ye.service.UserService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

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
    @Resource
    private UserService userService;

    @Test
    void selectTest(){
        /* System.out.println("----------selectList----------");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println); */
        System.out.println("----------selectList wrapper----------");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email","@")
                .ge("age",99);
        List<User> userList = userMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(userList)){
            System.out.println("123");
        }
        userList.forEach(System.out::println);

    }

    @Test
    void insertTest(){
        System.out.println("----------insert----------");
        User user = new User();
        user.setId(0L);
        user.setName("teilo");
        user.setAge(21);
        user.setEmail("123@teilo.com");
        int i = userMapper.insert(user);
        if (i == 1)
            System.out.println("success");
        userMapper.insert(new User("milk", 12, "123@milk.com"));
    }


    @Test
    void updateTest(){
        System.out.println("----------update----------");
        // 把 milk 的年龄改为 17
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.lambda()
                .set(User::getAge,17)
                .eq(User::getName,"milk");
        System.out.println(userMapper.update(null,wrapper) == 1 ? "update success" : "nothing to update");

    }

    @Test
    void deleteTest(){
        System.out.println("----------delete----------");
        // 删除 tailo
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.lambda()
                .eq(User::getName,"teilo");
        int i = userMapper.delete(wrapper);
        if ( i != 0)
            System.out.println("delete success");
    }

    @Test
    void getTest(){
        System.out.println("----------get----------");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(User::getId,8L);
        User user = userService.getOne(wrapper);
        System.out.println(user);
    }

    @Test
    void listTest(){
        System.out.println("----------list----------");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(User::getEmail,"@");
        List<User> userList = userService.list(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void saveTest(){
        System.out.println("----------save----------");
        User user = new User("lop",21,"756@lop.com");
        boolean flag = userService.save(user);
        System.out.println(flag);
    }

    @Test
    void serviceUpdateTest(){
        System.out.println("----------serviceUpdate----------");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        // 更新 id = 13 的数据
        wrapper.lambda()
                .set(User::getName,"colin")
                .set(User::getAge,22)
                .set(User::getEmail,"498@colin.com")
                .eq(User::getId,13L);
        boolean flag = userService.update(wrapper);
        System.out.println(flag);
    }

    @Test
    void removeTest(){
        System.out.println("----------remove----------");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.lambda()
                .eq(User::getId,12);
        boolean flag = userService.remove(wrapper);
        System.out.println(flag);
    }

    @Test
    void selectXmlTest(){
        System.out.println("----------selectXml----------");
        // xml 配置查询年龄为 17 的用户
        List<User> userList = userMapper.selectByAge(17);
        userList.forEach(System.out::println);
    }

    @Test
    void pageTest(){
        System.out.println("----------page----------");
        Page<User> page = new Page<>(2,2);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getEmail,"@")
                .ge(User::getId,1L)
                .between(User::getAge,2,26);
        userMapper.selectPage(page,wrapper);
    }


}
