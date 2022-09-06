package com.ye.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** 用户id */
    private Long id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
}
