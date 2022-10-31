package com.ye.common.result;

import lombok.Data;

/**
 * 统一返回结果集对象
 * @param <T>
 */
@Data
public class ResultSet<T> {

    /** 状态码 */
    private int code;
    /** 描述信息 */
    private String msg;
    /** 返回数据 */
    private T data;

    public ResultSet(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultSet(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
