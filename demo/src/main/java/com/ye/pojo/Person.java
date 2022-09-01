package com.ye.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {

    private String name;
    /** 性别 0：女，1：男 */
    private Integer gender;
    private List<Child> childs;
    private List<String> hobby;
}

