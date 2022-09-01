package com.ye.cache.qianqu1.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 10:31
 */
@Data
public class QQUserRequest {

    /** 性别，建议填写，有助于提升广告收益。0-女，1-男，2-未知 */
    private Integer gender;
    /** 年龄 */
    private Integer age;
    /** 兴趣爱好，我们会大数据检索相关广告定向下发。建议填写，有助于提升广告收益。例如：运动,购物,游戏,旅游等 */
    private Integer hobby;
}
