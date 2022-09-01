package com.ye.cache.huayi.resp;

import lombok.Data;

import java.util.List;

/**
 * @author yxd
 * @since 2022/8/17 16:39
 */
@Data
public class HYResponse {

    /** 响应状态码 0:请求成功 */
    private Integer error_code;
    /** 请求id */
    private String request_id;
    /** 广告内容 */
    private List<HYAdResponse> ads;

}
