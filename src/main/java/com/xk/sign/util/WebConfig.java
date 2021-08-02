package com.xk.sign.util;

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
          4.允许携带
          5.最大响应时间
         */
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080", null)
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }


}
