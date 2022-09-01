package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:11
 */
@Data
public class HYScreenSizeRequest {

    /** 设备屏幕宽度，单位:像素 必填 */
    private Integer width;
    /** 设备屏幕高度，单位:像素 必填 */
    private Integer height;
}
