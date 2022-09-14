package com.ye.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启 swagger2
public class MySwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("Ferao", "https://blog.csdn.net/qq_21561501", "928971634@qq.com");

        return new ApiInfo(
                "swaggerAPI文档",
                "11",
                "v1.0",
                "https://blog.csdn.net/qq_21561501",
                contact,
                "Apache2.0",
                "https://blog.csdn.net/qq_21561501",
                new ArrayList<>()
        );
    }

}
