package com.ye.common.result;

/**
 * http状态信息枚举
 * @author yxd
 */
public enum HttpStatusEnum implements HttpStatusHandler {

    SUCCESS(200, 200, "操作成功"),

    FAIL(400, 400,"操作失败"),

    SYSTEM_EXCEPTION(500, 500, "系统异常"),

    ;

    /** http 状态码 */
    private Integer httpCode;
    /** 业务状态码 */
    private Integer code;
    /** 状态信息 */
    private String message;

    HttpStatusEnum(Integer httpCode, Integer code, String message){
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    @Override
    public int getHttpCode(){
        return httpCode;
    }

    @Override
    public int getCode(){
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }

    public void setHttpCode(Integer httpCode ){
        this.httpCode = httpCode;
    }
    public void setCode(Integer code){
        this.code = code;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
