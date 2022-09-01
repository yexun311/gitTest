package com.ye.cache.qianqu1.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 10:34
 */
@Data
public class QQNetworkRequest {

    /** IPv4 地址,必须是外网 IP，不可以是局域网 IP，请求 IP 必须是手机的真实 IP， 不可以请求 IP 和广告上报 IP 不一 致 必填 */
    private String ip;
    /** IPv6 地址 */
    private String ip6;
    /** 连接网路类型
     * 0--CONNECTION_UNKNOW
     * 1--CELL_UNKNOWN
     * 2--CELL_2G
     * 3--CELL_3G
     * 4--CELL_4G
     * 5--CELL_5G
     * 100—WIFI
     * 101—ETHERNET
     * 999--NEW_TYPE
     * 必填
     */
    private Integer connectionType;
    /** 基站 ID */
    private String cellular_id;
    /**  运营商类型
     * 0--UNKNOWN_OPERATOR
     * 1--CHINA_MOBILE
     * 2--CHINA_TELECOM
     * 3--CHINA_UNICOM
     * 99--OTHER_OPERATOR
     * 必填
     */
    private Integer operatorType;
    /** 纬度(无法获取 填 0) 必填*/
    private Float lat;
    /** 经度（无法获取填 0 ） 必填 */
    private Float lon;
    /** 移动国家码 */
    private String mcc;
    /** 移动网络码 mnc 与 mcc 配合使 用，例如 mcc=412， mnc=01*/
    private String mnc;


}
