package com.ye;

import com.ye.pojo.AD;
import com.ye.pojo.Child;
import com.ye.pojo.MyArray;
import com.ye.pojo.Person;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    MyArray myArray;

    @Resource
    Person person;

    @Test
    void contextLoads() {
    }

    @Test
    public void myTest(){

        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓\n" + time);
        System.out.println(person.toString());

        System.out.println(test(3));

        person.setGender(null);
        System.out.println(person.toString());

        Calendar cal=Calendar.getInstance();

        // 当前年
        int year = cal.get(Calendar.YEAR);
        System.out.println(year + "年");

        Person person = new Person();
        person.setName("0");
        person.setGender(0);
        person.setChilds(Lists.newArrayList(new Child()));

        if(CollectionUtils.isEmpty(person.getChilds()))
            System.out.println("列表为空");
        Child child = person.getChilds().get(0);
        if(Objects.isNull(child))
            System.out.println("child 为空");
        if(child.getAge() == null)
            System.out.println("child Age 为空");

        person.setHobby(Lists.newArrayList(child.getHobby()));

        System.out.println("------------------------------");
        String str = "0123456";
        System.out.println(str.substring(0,7));
    }

    public Integer test(Integer i){
        switch (i){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                return 0;
        }
    }

}
