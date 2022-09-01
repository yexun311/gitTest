package com.ye.cache.huayi.resp;

import lombok.Data;

import java.util.List;

/**
 * @author yxd
 * @since 2022/8/17 16:41
 */
@Data
public class HYVideoProgressUrlResp {

    /** 视频播放到指定秒上报列表 */
    private Integer second;
    /** 视频播放过程上报网址列表 */
    private List<String> url;
}
