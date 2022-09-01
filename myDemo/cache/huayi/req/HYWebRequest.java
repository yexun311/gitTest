package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 15:53
 */
@Data
public class HYWebRequest {

    /** 请求页面的URL */
    private String url;
    /** 请求页面的标题 */
    private String title;
    /** 页面内容来源网址URl */
    private String source_url;
    /** 请求页面metadata关键字 */
    private String keywords;
    /** 当前站点主域名 */
    private String domain;
}
