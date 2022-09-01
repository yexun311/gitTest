package com.ye.cache.qianqu1.resp;

import lombok.Data;

import java.util.List;

/** 千曲响应参数
 * @author yxd
 * @since 2022/8/17 13:25
 */
@Data
public class QQResponse {

    /** 请求 ID */
    private String requestId;
    /** 请求应答码 0-请求成功，有广告填充 1-请求成功，无广告填充 */
    private String errorCode;
    /** 请求应答消息 */
    private String msg;
    /** 广告对象信息 */
    private List<QQAdsResponse> ads;
}
