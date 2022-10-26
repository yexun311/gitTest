package com.ye.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.ye.testLib.Test001;
import com.ye.testLib.Test383;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class LeetCodeApplicationTests {

    @Test
    void contextLoads() {
    }

    private final Test001 test001 = new Test001();

    @Test
    void LeetCodeTest1(){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        test001.merge(arr1,3,arr2,3);
        for (int a : arr1){
            System.out.print(a + ",");
        }

        System.out.println("\n//////////////////////////////");

        String test = "  this               is  a sentence ";
        System.out.println(test001.reorderSpaces(test));
    }

    @Test
    void leetCodeTest2(){
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        System.out.println(test001.canFormArray(arr, pieces));

    }

    @Test
    void myTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.append("ef");
        System.out.println(sb);
        sb.insert(3,"d");
        System.out.println(sb);
        sb.delete(5,6);
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);

        System.out.println("//////////////////////////////");

        String str = "  abc d  e   f     ";
        String[] strs = str.split(" ");
        StringBuilder sb1 = new StringBuilder();
        for (String s : strs){
            if (!s.equals(""))
                sb1.append(s).append(" ");
        }
        System.out.println(sb1);

        System.out.println("//////////////////////////////");
        Integer s = null;
        System.out.println(s);
    }

    @Test
    void myTest01(){
        List<Integer> list = new ArrayList<>(Lists.newArrayList(1,2,3,4,5,6,7));
        System.out.println(list);

    }

}
