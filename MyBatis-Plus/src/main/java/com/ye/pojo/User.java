package com.ye.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 数据库中字段名不一致时可指定
    @TableField("name")
    private String name;
    private Integer age;
    private String email;

    /* create_time
    update_time */

    public User(){}

    public User(Long id, String name, Integer age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
