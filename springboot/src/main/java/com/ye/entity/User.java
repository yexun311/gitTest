package com.ye.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class User implements Serializable {

    /** 用户id */
    private Long id;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 出生日期 */
    private Date birth;
    /** 0-未删除，1-已删除 */
    private Integer isDeleted;

    public User(Long id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User(Long id, String userName, String password, Integer isDeleted) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isDeleted = isDeleted;
    }
}
