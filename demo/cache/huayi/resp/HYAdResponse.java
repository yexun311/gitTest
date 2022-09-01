package com.ye.cache.huayi.resp;

import lombok.Data;

import java.util.List;

/**
 * @author yxd
 * @since 2022/8/17 16:55
 */
@Data
public class HYAdResponse {

    /** 广告推广标题 */
    private String ad_title;
    /** 广告标识 */
    private String ad_key;
    /** "广告"小图标地址 */
    private String mob_adtext;
    /** 第三方广告图标，比如百度的熊掌图标 */
    private String mob_adlogo;
    /** 广告品牌名称，下载类则为app名称（如手机XXX），非下载类则为品牌名称（如 XXX） */
    private String brand_name;
    /** 广告描述 */
    private String description;
    /** HTML片段 */
    private String html_snippet;
    /** 广告图片地址 */
    private List<String> image_src;
    /** 图片的宽度 */
    private Integer material_width;
    /** 图片的高度 */
    private Integer material_height;
    /** 广告图标地址 */
    private List<String> icon_src;
    /** 创意类型：
     0：无创意类型
     1：纯文字广告
     2：纯图片广告
     3：图文混合广告
     4：视频广告 */
    private Integer creative_type;
    /** 交互类型：
     0 无动作，即广告广告点击后无需进行任何响应
     1 使用浏览器打开网页
     2 下载应用
     3 deeplink唤醒 */
    private Integer interaction_type;
    /** 下载类广告包名 */
    private String app_package;
    /** 下载类广告应用文件大小 */
    private Integer app_size;
    /** 广告落地页地址，当广告被点击时，需引导用户跳转到此广告落地承载页URL。 */
    private String link_url;
    /** deeplink唤醒打开页面，如果有优先唤醒 */
    private String deeplink_url;
    /** 广告视频物料地址 */
    private String video_url;
    /** 广告视频物料时长，单位：秒 */
    private Integer video_duration;
    /** 物料有效时间，单位：秒 */
    private Integer expiration_time;
    /** 唤醒广告退化交互方式 */
    private Integer fallback_type;
    /** deeplink唤醒失败后打开的地址，也可以直接打开落地页 */
    private String fallback_url;
    /** 下载类广告填充，用于判断是否需要二次下载 */
    private Integer protocol_type;
    /** 客户端是否预先加载广告视频。 */
    private Integer prefetch;
    /** 贴片信息 */
    private HYCardResponse card;
    /** 广告上报信息 */
    private HYAdTrackingResp ad_tracking;

    /** 返回视频VAST模板 */
    Object vast;
    /** 广告扩展信息 */
    Object ext;

}
