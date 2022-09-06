package com.ye.common;

import lombok.Data;

/**
 * 统一的 json 返回结构
 * @param <T>
 */
@Data
public class JsonResult<T> {

    /** 状态码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 返回数据 */
    private T data;

    /**
     * 若没有数据返回，默认状态码为 1
     */
    public JsonResult(){
        this.code = 1;
        this.msg = "数据可以是任何形式，包括空白...";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回，状态码为 0
     * @param data
     */
    public JsonResult(T data){
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为 0，人为指定提示信息
     * @param msg
     * @param data
     */
    public JsonResult(String msg,T data){
        code = 0;
        this.data = data;
        this.msg = msg;
    }
}
