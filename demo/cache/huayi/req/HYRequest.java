package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * 华毅亮点请求参数
 * @author yxd
 * @since 2022/8/17 15:52
 */
@Data
public class HYRequest {

    /** 请求id，媒体侧生成，需确保全局唯一，最大长度为36位 必填 */
    private String request_id;
    /** 广告位信息 必填 */
    private HYAdslotRequest adslot;
    /** API版本信息 必填 */
    private HYApiVersionRequest api_version;
    /** 应用参数信息 必填 */
    private HYAppRequest app;
    /** 设备参数信息 必填 */
    private HYDeviceRequest device;
    /** 移动网络参数信息 必填 */
    private HYNetworkRequest network;
    /** GPS参数信息 必填 */
    private HYGpsRequest gps;
    /** 无线网络参数信息 必填 */
    private HYWifiRequest wifi;
    /** 是否支持返回https物料。(1：http，2：https，默认1) */
    private Integer request_protocol_type;
    /** 是否支持deeplink唤醒，(true：支持，false：不支持，默认false) 必填 */
    private Boolean support_deeplink;
    /** Web页面特征 */
    private HYWebRequest web;;
}
