package com.ye.config;

import com.ye.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web config
 */
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                // 拦截所有请求
                //.addPathPatterns("/**")
                // 放行请求
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/login");
    }
}
