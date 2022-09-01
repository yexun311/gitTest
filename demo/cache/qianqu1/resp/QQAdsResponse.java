package com.ye.cache.qianqu1.resp;

import lombok.Data;

import java.util.List;

/** 广告对象信息
 * @author yxd
 * @since 2022/8/17 13:18
 */
@Data
public class QQAdsResponse {

    /** 广告位 ID */
    private String slotId;
    /** 广告唯一标示 */
    private String adKey;
    /** 物料元数据组 */
    private List<QQMetaGroupResp> metaGroup;
    /** 广告监控信息 */
    private List<QQTrackResponse> tracks;
    /** 广告 logo 图标地址 媒体需要在渲染的时候添加 */
    private String adlogo;
    /** 广告小图标地址 媒体需要在渲染的时候添加 */
    private String adtext;
    /** 开屏广告做适配的时候素材填充背景图，非开屏广告忽略 */
    private String adsimg;
    /** 广告展示 ID */
    private String viewId;
    /** HTML 片段 */
    private String htmlSnippet;
    /** 是否宏替换标志，该字段不为空且值为 1，表示上报 连接 或 clickUrl 需要进行宏替换处理 */
    private Integer protocolType;


}
