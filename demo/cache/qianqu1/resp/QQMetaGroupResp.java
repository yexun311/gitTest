package com.ye.cache.qianqu1.resp;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssp.common.annotation.MonitorType;
import com.ssp.common.enums.system.MonitorTypeEnum;
import lombok.Data;

import java.util.List;

/** 广告物料元素
 * @author yxd
 * @since 2022/8/17 11:16
 */
@Data
public class QQMetaGroupResp {

    /** 物料的宽度 */
    private Integer materialWidth;
    /** 物料的高度 */
    private Integer materialHeight;
    /** 广告图片地址 */
    private List<String> imageUrl;
    /** 广告描述 */
    private List<String> descs;
    /** 广告图标地址 */
    private List<String> iconUrls;
    /** 点击跳转地址 */
    private String clickUrl;
    /** 创意类型 1--纯文字 2--纯图片 3--图文混合 4--视频广告 5--其它 */
    private Integer creativeType;
    /** 广告类型 1--浏览 2--下载 0--其他 */
    private Integer interactionType;
    /** 下载类广告类型 interactionType=2 时有用
     * 1 – 一键下载(下载地址在 本次返回的素材中， clickUrl 或 downloadLink)
     * 2 – 二次请求下载(下载地址不在本次返回的素材中， 需要再次请求 clickUrl 获取) */
    private Integer downType;
    /** 下载类广告应用包名 */
    private String packageName;
    /** 下载类广告应用大小 */
    private Integer appSize;
    /** 包 md5 值 */
    private String apkMd5;
    /** 应用包版本名称 */
    private String apkVer;
    /** 应用包版本号 id */
    private String verCode;
    /** 当前元数据所在索引 */
    private Integer currentIndex;
    /** 广告品牌名称, 下载类为 app 名，非下载类为推广的品牌名 */
    private String brandName;
    /** 广告推广标题 */
    private String adTitle;
    /** 下载地址 */
    private String downloadLink;
    /** deeplink 地址 interactionType 定义了广告的交互方式。如果 interactionType=1，如果 deepLink 存在，优先尝试调起 deepLink;
     * 如果 deepLink 不存在或者调起 deepLink 失败，则使用浏览器或者 webview 控件打开 clickUrl
     * 如果 interactionType=2, 如果 deepLink 存在，优先尝 试调起 deepLink;
     * 如果 deepLink 不存在或者调起 deepLink 失败，则使用下载模块下载 downloadLink 指定的 apk 应用，并安装应用。 */
    private String deepLink;
    /** 广告视频物料地址 */
    private String videoUrl;
    /** 广告视频物料时长 */
    private Integer videoDuration;
    /** 广告视频物料大小，单位是 KB */
    private Integer videoSize;
    /** 广告视频物料高度 */
    private Integer videoHeight;
    /** 广告视频物料宽度 */
    private Integer videoWidth;
    /** 广告标内容, 非空必须展示，为空则不展示 */
    private String adMark;
    /** 曝光 URL 列表 */
    private List<String> winNoticeUrls;
    /** 点击 URL 列表 */
    private List<String> winCNoticeUrls;
    /**
     * 开始下载上报地址，只有下载类广告才有返回
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_STARTDOWNLOAD_NUM)
    private List<String> arrDownloadTrackUrl;
    /**
     * 下载完成上报地址，只有下载类广告才有返回
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCDOWNLOAD_NUM)
    private List<String> arrDownloadedTrackUrl;
    /**
     * 开始安装上报地址，只有下载类广告才有返回
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_STARTINSTALL_NUM)
    @JSONField(name = "arrIntallTrackUrl")
    private List<String> arrInstallTrackUrl;
    /**
     * 安装完成上报地址，只有下载类广告才有返回
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCINSTALL_NUM)
    @JSONField(name = "arrIntalledTrackUrl")
    private List<String> arrInstalledTrackUrl;
    /**
     * 跳过广告上报地址
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_CLOSEAPP_NUM)
    private List<String> arrSkipTrackUrl;
    /**
     * 点击 deeplink 广告上报地址
     */
    private List<String> dpClickTrackUrls;
    /**
     * deepLink 调起成功的上报地址
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCDEEPLINK_NUM)
    private List<String> dpSuccessTrackUrl;
    /**
     * deepLink 调起失败的上报地址
     */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_FAILDEEPLINK_NUM)
    private List<String> dpFailedTrackUrl;
    /** 广告控制信息，视频广告有用，非视频广告可忽略*/
    private QQAdControlResponse adControl;

}
