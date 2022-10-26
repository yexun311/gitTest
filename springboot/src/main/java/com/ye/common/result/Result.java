package com.ye.common.result;

import lombok.Data;

/**
 * 统一返回对象
 * @param <T>
 */
@Data
public class Result<T> {

    /** 状态码 */
    private int code;
    /** 提示信息 */
    private String msg;
    /** 返回数据 */
    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
