package com.fierew.adminx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuyang
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Value(value = "${server.port}")
    private String port;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(port);
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:" + port)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}