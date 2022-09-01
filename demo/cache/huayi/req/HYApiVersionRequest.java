package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:30
 */
@Data
public class HYApiVersionRequest {

    /** 主版本号 必填 */
    private Integer major;
    /** 副版本号 */
    private Integer minor;
    /** 小版本号 */
    private Integer micro;
}
