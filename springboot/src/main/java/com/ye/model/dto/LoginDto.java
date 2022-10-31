package com.ye.model.dto;

import lombok.Data;

/**
 * 用户登录缓存信息
 */
@Data
public class LoginDto {

    /** 用户id */
    private Long id;
    /** 账号 */
    private String account;
    /** 用户姓名 */
    private String userName;

}
