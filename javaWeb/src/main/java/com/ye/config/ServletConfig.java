package com.ye.config;

import com.ye.servlet.GetServlet;
import com.ye.servlet.HelloServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * @author yx
 * @since 2022-11-25
 */
@Configuration
public class ServletConfig {

    // 注册 HelloServlet
    @Bean
    public ServletRegistrationBean<HelloServlet> servletServletRegistrationBean(){

        ServletRegistrationBean<HelloServlet> servlet = new ServletRegistrationBean<>();

        servlet.setServlet(new HelloServlet());
        servlet.addUrlMappings("/helloServlet");

        return servlet;
    }

    // 注册 GetServlet
    @Bean
    public ServletRegistrationBean<GetServlet> servletServletRegistrationBean1(){

        ServletRegistrationBean<GetServlet> servlet = new ServletRegistrationBean<>();

        servlet.setServlet(new GetServlet());
        servlet.addUrlMappings("/getServlet");

        return servlet;
    }

}
