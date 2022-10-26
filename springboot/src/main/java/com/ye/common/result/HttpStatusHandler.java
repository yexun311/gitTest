package com.ye.common.result;

/**
 * http 状态码接口
 * 枚举实现
 * @author yxd
 */
public interface HttpStatusHandler {

    /** 获取 http 状态码 */
    int getHttpCode();

    /** 获取业务状态码 */
    int getCode();

    /** 获取状态信息 */
    String getMessage();
}
