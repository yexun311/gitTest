package com.ye.cache.huayi.resp;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:52
 */
@Data
public class HYCardResponse {

    /** 视频前贴片图片，与precardhtml互斥，返回其中一个 */
    private String preimgurl;
    /** 视频前贴片html */
    private String precardhtml;
    /** 视频后贴片图片，与endcardhtml互斥，返回其中一个 */
    private String endimgurl;
    /** 视频后贴片html */
    private String endcardhtml;
    /** 视频播放完成，展示该图标 */
    private String endiconurl;
    /** 视频播放完成，展示该标题 */
    private String endtitle;
    /** 视频播放完成，展示该描述 */
    private String enddesc;
    /** 视频播放完成，展示的按钮 */
    private String endbutton;
    /** 视频播放完成，点击的落地页 */
    private String endbuttonurl;
    /** 视频播放完成，展示的评分 */
    private Integer endrating;
    /** 视频播放完成，展示的评论数 */
    private Integer endcomments;
}
