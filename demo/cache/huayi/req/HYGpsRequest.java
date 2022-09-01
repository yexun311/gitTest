package com.ye.cache.huayi.req;

import lombok.Data;

/**
 * @author yxd
 * @since 2022/8/17 16:00
 */
@Data
public class HYGpsRequest {

    /** GPS坐标经度 必填 */
    private Double longitude;
    /** GPS坐标纬度 必填 */
    private Double latitude;
    /** 1：全球卫星定位系统坐标系;
     2：国家测绘局坐标系,;
     3：百度坐标系; */
    private Integer coordinate_type;
    /** GPS时间戳信息，单位：毫秒 */
    private Long timestamp;
    /** 定位精度 */
    private Integer accu;
}
