package com.ye.common;

import lombok.Data;

@Data
public class Result<T> {

    public static final Integer ONE = 1;
    public static final Integer ZERO = 0;

    /** 状态码 1-有数据，0-空 */
    private Integer code;
    /** 描述信息 */
    private String msg;
    /** 数据 */
    private T data;

    public Result(String msg){
        this.code = ZERO;
        this.msg = "无数据：" + msg;
    }

    public Result(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
