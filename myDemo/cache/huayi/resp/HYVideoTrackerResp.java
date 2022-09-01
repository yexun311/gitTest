package com.ye.cache.huayi.resp;

import com.ssp.common.annotation.MonitorType;
import com.ssp.common.enums.system.MonitorTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @author yxd
 * @since 2022/8/17 16:42
 */
@Data
public class HYVideoTrackerResp {

    /** 视频开始播放上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOSTARTNUM_NUM)
    private List<String> video_start_url;
    /** 视频播放结束上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOFINISH_NUM)
    private List<String> video_end_url;

    /** 视频播放进度上报列表 */
    private List<HYVideoProgressUrlResp> video_progress_url;
    /** 视频广告加载成功上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOLOADSUCC_NUM)
    private List<String> loaded_url;
    /** 播放视频错误上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOLOADFAIL_NUM)
    private List<String> play_error_url;
    /** 全屏播放上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOFULL_NUM)
    private List<String> fullscreen_url;
    /** 退出全屏播放上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOOUT_NUM)
    private List<String> unfullscren_url;
    /** 静音事件上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOMUTEL_NUM)
    private List<String> mute_url;
    /** 关闭静音事件上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOCANCEL_NUM)
    private List<String> unmute_url;
    /** 点击预览图播放视频 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOCLICK_NUM)
    private List<String> start_card_click_url;

    /** 服务器激励回调上报 */
    private List<String> callback_trackers;
    /** 视频暂停播放上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOSTOP_NUM)
    private List<String> video_pause_url;
    /** 视频取消暂停上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOCONTINUE_NUM)
    private List<String> video_resume_url;
    /** 视频继续播放上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOCONTINUE_NUM)
    private List<String> video_continue_url;
    /** 上滑事件上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEOUP_NUM)
    private List<String> upscroll_url;
    /** 下滑事件上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_VIDEODOWN_NUM)
    private List<String> downscroll_url;

}
