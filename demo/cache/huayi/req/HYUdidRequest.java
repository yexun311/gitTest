package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:07
 */
@Data
public class HYUdidRequest {

    /** Android设备唯一标识码，安卓必填 */
    private String imei;
    /** 安卓10及以上版本必填 */
    private String oaid;
    /** 国际移动客户识别码，建议填写 */
    private String imsi;
    /** Android设备ID，安卓必填 */
    private String android_id;
    /** Mac地址 */
    private String mac;
    /** iOS设备唯一标识码，IOS系统必填 */
    private String idfa;
    /** Ios设备的应用开发商标识符，IOS系统必填 */
    private String idfv;
    /** IOS备的openudid值 */
    private String openudid;
    /** 设备sn码 */
    private String serial_number;
    /** 设备广告id */
    private String aaid;
    /** idfa经过MD5方式加密 */
    private String idfa_md5;
    /** imei经过MD5方式加密 */
    private String imei_md5;
    /** imei经过SHA1方式加密 */
    private String imei_sha1;
    /** androidud经过MD5方式加密 */
    private String androidid_md5;
    /** androidid经过SHA1方式加密 */
    private String androidid_sha1;
    /** mac转大写后MD5方式加密 */
    private String mac_md5;
    /** 中国广告协会互联网广告标识(CAID)，有了尽量传 */
    private String caid;
}
