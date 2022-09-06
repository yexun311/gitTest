package com.ye.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MyFastJsonConfig extends WebMvcConfigurationSupport {

    /**
     * 使用阿里 FastJson 作为 Json MessageConverter
     * 将 null 数据的 Json 格式改成另一种形式
     * @Param converers
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
            // 保留 map 空的字段
            SerializerFeature.WriteMapNullValue,
            // 将 String 类型的 null 转成 ”“
            SerializerFeature.WriteNullStringAsEmpty,
            // 将 Number 类型的 Null 转成 0
            SerializerFeature.WriteNullNumberAsZero,
            // 将 List 类型的 Null 转成 []
            SerializerFeature.WriteNullListAsEmpty,
            // 将 Boolean 类型的 Null 转成 false
            SerializerFeature.WriteNullBooleanAsFalse,
            // 避免循环引用
            SerializerFeature.DisableCircularReferenceDetect);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        List<MediaType> mediaTypeList = new ArrayList<>();

        // 解决中文乱码问题
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);

    }

}
