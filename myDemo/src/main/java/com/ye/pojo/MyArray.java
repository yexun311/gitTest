package com.ye.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyArray {

    int[] myArray;

    /** 查找次数 */
    int count;

}
