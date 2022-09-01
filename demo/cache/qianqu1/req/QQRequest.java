package com.ye.cache.qianqu1.req;

import lombok.Data;

/** 千曲请求参数
 * @author yxd
 * @since 2022/8/17
 */
@Data
public class QQRequest {

    /** 请求 ID，需要保证唯一 必填 */
    private String requestId;
    /** 代码位 ID，需运营后台配置 必填 */
    private String channelId;
    /** 是否使用 HTTPS 0-不需要 1-需要 必填 */
    private Integer secure;
    /** 设备相关信息 必填 */
    private QQDeviceRequest device;
    /** 网络相关信息 必填 */
    private QQNetworkRequest network;
    /** 用户属性。建议填写，有助于提升广告收益 必填 */
    private QQUserRequest user;
    /** 扩展信息占位符 */
    private QQExtRequest ext;

}
