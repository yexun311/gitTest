package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:31
 */
@Data
public class HYAdslotSizeRequest {

    /** 广告位宽度 必填 */
    private Integer width;
    /** 广告位高度 必填 */
    private Integer height;
}
