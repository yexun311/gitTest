package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:00
 */
@Data
public class HYNetworkRequest {

    /** 公网IPv4 地址 必填 */
    private String ipv4;
    /** 公网ipv6地址 */
    private String ipv6;
    /** 网络类型
     0 无法探测网络状态;
     1 蜂窝数据接入;
     2：2G网络;
     3： 3G网络;
     4： 4G网;
     5： 5G网络;
     100：Wi-Fi网络
     101：以太网接入;
     999：未知新类型
     必填
     */
    private Integer connection_type;
    /** 运营商类型
     0：未知运营商;
     1: 中国移动;
     2: 中国电信;
     3: 中国联通;
     99: 其他运营商;
     必填
     */
    private Integer operator_type;
    /** 基站Id */
    private String cellular_id;
    /** 移动国家码 示例：460 */
    private String mcc;
    /** 移动网络码 示例：00 */
    private String mnc;
}
