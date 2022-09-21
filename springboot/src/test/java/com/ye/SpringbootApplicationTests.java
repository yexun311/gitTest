package com.ye;

import com.google.common.collect.Lists;
import com.ye.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static java.lang.System.in;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     *
     * 获取当前时间
     */
    @Test
    void myTest2(){
        System.out.println("-----System-----");
        System.out.println(System.currentTimeMillis());

        System.out.println("-----Date-----");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        System.out.println("-----Calendar-----");
        Date calendar = Calendar.getInstance().getTime();
        System.out.println(calendar);

        System.out.println("-----LocalDate-----");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println("-----LocalTime-----");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println("-----LocalDateTime-----");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }

    @Test
    void myTest1(){
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        System.out.println(strList);
        strList.clear();
        System.out.println(strList);
        strList.add("3");
        System.out.println(strList);
    }



}
