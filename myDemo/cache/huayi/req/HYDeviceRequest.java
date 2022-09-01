package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:14
 */
@Data
public class HYDeviceRequest {

    /** 设备类型
     1：手机(含iTouch) 2：平板
     3：智能电视4：户外屏幕 */
    private Integer device_type;
    /** 操作系统
     1：ANDROID 2：IOS */
    private Integer os_type;
    /** 操作系统版本信息 */
    private HYOsVersionRequest os_version;
    /** 设备厂商名称 示例：HUAWEI */
    private String vendor;
    /** 设备品牌 示例：honor*/
    private String brand;
    /** 设备型号 示例：iPhone10,3；ALP-AL00 */
    private String model;
    /** 设备屏幕尺寸信息 */
    private HYScreenSizeRequest screen_size;
    /** 设备浏览器UA */
    private String user_agent;
    /** 设备横竖屏，默认为竖屏
     1：横屏，2：竖屏 */
    private Integer orientation;
    /** 设备唯一标识对象 */
    private HYUdidRequest udid;
    /** 屏幕像素密度 */
    private Integer ppi;
    /** 屏幕分辨率
     安卓参考:DisplayMetrics.density
     iOS参考:UIScreen.scale */
    private Double density;
    /** 屏幕分辨率
     安卓参考:DisplayMetrics.density
     iOS参考:UIScreen.scale */
    private String rom_version;
    /** 系统编译时间(ro.build.date.utc)，精确至毫秒  */
    private Long sys_compiling_time;
    /** 用户设备HTTP请求头中的referer字段 */
    private String referer;
    /** 国家编码(ISO-3166-1/alpha-2) 示例：CN */
    private String country;
    /** 设备语言(ISO-639-1/alpha-2) 示例：zh */
    private String language;
    /** 系统所在时区 示例：Asia/Shanghai */
    private String timezone;
    /** 设备开机时间(秒级时间戳)，小数点后保留6位，IOS系统必填 */
    private String startup_time;
    /** 手机名称，IOS系统必填 */
    private String phone_name;
    /** 手机内存总空间(单位：字节)，IOS系统必填 */
    private Long mem_total;
    /** 手机磁盘总空间(单位：字节)，IOS系统必填 */
    private Long disk_total;
    /** 系统更新时间(秒级时间戳)，小数点后保留 6位，IOS系统必填 */
    private String mb_time;
    /** 设备model，IOS系统必填 */
    private String mode_code;
    /** 广告标识授权情况，是否允许获取IDFA，仅IOS系统填写
     0：未确定1：受限制
     2：被拒绝3：授权 */
    private Integer auth_status;
    /** 设备CPU个数，IOS系统必填 */
    private Integer cpu_num;
    /** 电池充电状态，IOS系统必填
     Unknow：未知
     Unplugged：不充电
     Charging：充电
     Full：满电 */
    private String battery_status;
    /** 电池电量百分比，IOS系统必填 */
    private Integer battery_power;
    /** 手机CPU频率，单位：GHz, IOS 系统必填 */
    private Double cpu_frequency;
    /** 设备硬件版本 */
    private String hwv;
    /** 安卓API等级(iOS不填) */
    private Integer api_level;
    /** 应用商店版本号 */
    private String storever;
    /** 华为hms版本号 */
    private String hmsver;

}
