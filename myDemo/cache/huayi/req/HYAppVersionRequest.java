package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:26
 */
@Data
public class HYAppVersionRequest {

    /** 应用主版本号 必填 */
    private Integer major;
    /** 应用副版本号 */
    private Integer minor;
    /** 操应用小版本号 */
    private Integer micro;
}
