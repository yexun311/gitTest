package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:32
 */
@Data
public class HYAdslotRequest {

    /** 广告位id 必填 */
    private String adslot_id;
    /** 广告位尺寸信息 必填 */
    private HYAdslotSizeRequest adslot_size;
}
