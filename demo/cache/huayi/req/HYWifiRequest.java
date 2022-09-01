package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 15:56
 */
@Data
public class HYWifiRequest {

    /** 无线热点MAC地址，如获取不到可不传 必填 */
    private String ap_mac;
    /** 无线网ssid名称，如获取不到可不传 必填 */
    private String ap_name;
    /** 是否是当前连接热点 */
    private Boolean is_connected;
    /** 热点信号强度 */
    private String rssi;
}
