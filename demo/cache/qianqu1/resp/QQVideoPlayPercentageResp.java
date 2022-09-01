package com.ye.cache.qianqu1.resp;

import lombok.Data;

import java.util.List;

/** 视频播放进度上报地址信息
 * @author yxd
 * @since 2022/8/17 11:08
 */
@Data
public class QQVideoPlayPercentageResp {
/** ：目前只有视频类广告才会启用该字段，其他类型该字段为空 */

    /** 播放进度，0.25 表示 25% */
    private Float checkPoint;
    /** 上报地址 */
    private List<String> urls;

}
