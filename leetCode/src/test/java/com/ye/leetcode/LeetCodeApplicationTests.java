package com.ye.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import testLib.Test001;
import testLib.Test383;

@SpringBootTest
class LeetCodeApplicationTests {

    @Test
    void contextLoads() {
    }


    private Test383 test383 = new Test383();
    private Test001 test001 = new Test001();

    @Test
    void LeetCodeTest1(){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        test001.merge(arr1,3,arr2,3);
        for (int a : arr1){
            System.out.print(a + ",");
        }
    }

}
