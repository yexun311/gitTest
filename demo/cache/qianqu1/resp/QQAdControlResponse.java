package com.ye.cache.qianqu1.resp;

import lombok.Data;

/** 广告控制信息
 * @author yxd
 * @since 2022/8/17 11:13
 */
@Data
public class QQAdControlResponse {

    /** 广告时长，从广告渲染成功并对用户可见起算，单位:毫秒 */
    private Long duration;
    /** 仅离线广告有效，广告有效性的起始时间，单位:毫秒 */
    private Long startTimeInMills;
    /** 仅离线广告有效，广告有效性的截止时间，单位:毫秒 */
    private Long EndTimeInMills;
}
