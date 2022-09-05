package com.ipisces42.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fuhaixin
 * @date 2022/8/17
 **/
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedOriginPatterns("*")
            .allowedMethods("GET", "DELETE", "PUT", "POST", "OPTIONS")
            .allowCredentials(true).maxAge(3600);

        // Add more mappings...
    }
}
