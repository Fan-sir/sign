package com.xk.sign.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//全局配置类——配置跨域请求
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
          1.访问路径
          2.请求来源
          3.方法
          允许请求头
          4.允许携带
          5.最大响应时间
         */
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
//                .allowedOrigins("http://www.xkyun.top:12033", "http://202.189.6.200:12033", "http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }


}
