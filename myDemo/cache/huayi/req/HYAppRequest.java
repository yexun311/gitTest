package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:27
 */
@Data
public class HYAppRequest {

    /** 应用ID 必填 */
    private String app_id;
    /** 应用包名，需要跟提交的应用一致 必填 */
    private String app_package;
    /** 应用版本 必填 */
    private HYAppVersionRequest app_version;
}
