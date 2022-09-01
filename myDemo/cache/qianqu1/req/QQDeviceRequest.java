package com.ye.cache.qianqu1.req;

import lombok.Data;

/**
 * @auhor yxd
 * @since 20228/17 10:42
 */
@Data
public class QQDeviceRequest {

    /** IOS 设备唯一标识码 必填 */
    private String idfa;
    /** 安卓设备唯一标识码 必填 */
    private String imei;
    /** 设备 Wifi 网卡 MAC 地址 必填 */
    private String mac;
    /** 安卓设备 ID 必填 */
    private String androidId;
    /** 安卓 10 或以上系统要求必填 必填 */
    private String oaid;
    /** 设备型号 必填 */
    private String model;
    /** 设备厂商 必填 */
    private String vendor;
    /** 设备屏幕高度 必填 */
    private Integer screenHeight;
    /** 设备屏幕宽度 必填 */
    private Integer screenWidth;
    /** 操作系统类型。1-Android 2-IOS 必填 */
    private Integer osType;
    /** 操作系统版本 必填 */
    private String osVersion;
    /** 设备类型 1-手机 2-平板 必填 */
    private Integer deviceType;
    /** User-agent 必填 */
    private String ua;
    /** 屏幕大小(单位 ppi,每 英寸所 有的像素) 必填 */
    private Integer ppi;
    /** 横竖屏 0-未知 1-竖屏 2-横屏 必填 */
    private Integer screenOrientation;
    /** 手机品牌 必填 */
    private String brand;
    /** imsi 如不填写可能会影响变现能力 */
    private String imsi;

}
