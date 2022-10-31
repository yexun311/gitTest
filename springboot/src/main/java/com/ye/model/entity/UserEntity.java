package com.ye.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {

    /** 用户id */
    private Long id;
    /** 账号 */
    private String account;
    /** 密码 */
    private String password;
    /** 用户名 */
    private String userName;
    /** 出生日期 */
    private Date birth;
    /** 0-未删除，1-已删除 */
    private Integer isDeleted;

    public UserEntity(Long id, String account, String password){
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public UserEntity(Long id, String account, String password, String userName, Integer isDeleted) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.isDeleted = isDeleted;
    }
}
