package com.ye.cache.huayi.resp;

import com.ssp.common.annotation.MonitorType;
import com.ssp.common.enums.system.MonitorTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @author yxd
 * @since 2022/8/17 16:46
 */
@Data
public class HYAdTrackingResp {

    /** 曝光广告上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SHOW_NUM)
    private List<String> ad_exposure_url;
    /** 点击广告上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_CLICK_NUM)
    private List<String> ad_click_url;
    /** 关闭广告上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_CLOSEAPP_NUM)
    private List<String> ad_close_url;

    /** 跳过广告上报地址列表 */
    private List<String> ad_skip_url;
    /** 开始下载上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_STARTDOWNLOAD_NUM)
    private List<String> app_ad_download_begin_url;
    /** 下载完成上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCDOWNLOAD_NUM)
    private List<String> app_ad_download_finish_url;
    /** 开始安装上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_STARTINSTALL_NUM)
    private List<String> app_ad_install_begin_url;
    /** 安装完成上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCINSTALL_NUM)
    private List<String> app_ad_install_finish_url;
    /** 安装后打开上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_OPENAPP_NUM)
    private List<String> app_ad_install_open_url;
    /** 唤醒成功上报地址列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_SUCCDEEPLINK_NUM)
    private List<String> dp_success_url;
    /** 唤醒失败上报列表 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_FAILDEEPLINK_NUM)
    private List<String> dp_fail_url;

    /** 尝试唤醒上报列表 */
    private List<String> dp_try_url;
    /** 该设备上已经有app直接打开上报 */
    @MonitorType(cname = MonitorTypeEnum.ChannelEnum.C_DEEPLINKAPPYES_NUM)
    private List<String> action_url;
    /** 视频类上报信息 */
    private List<HYVideoTrackerResp> video_tracker;

}
