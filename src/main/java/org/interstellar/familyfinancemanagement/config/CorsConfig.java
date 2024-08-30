package org.interstellar.familyfinancemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author interstellar
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("http://localhost:9090",
                        "http://192.168.188.85:8080",
                        "http://192.168.188.37:5173")
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许跨域的时长
                .maxAge(3600);
    }
}
