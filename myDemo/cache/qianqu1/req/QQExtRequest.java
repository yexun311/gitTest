package com.ye.cache.qianqu1.req;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 10:29
 */
@Data
@AllArgsConstructor
public class QQExtRequest {

    /** 是否支持宏替换 1-是，0-否 */
    private Integer supportDeeplink;
}
