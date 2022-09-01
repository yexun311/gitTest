package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:13
 */
@Data
public class HYOsVersionRequest {

    /** 操作系统主版本号 必填 */
    private Integer major;
    /** 操作系统副版本号 必填 */
    private Integer minor;
    /** 操作系统小版本号 必填 */
    private Integer micro;
}
