package kr.co.joylog.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://joylog.co.kr",
                        "https://joylog.co.kr",
                        "http://api.joylog.co.kr",
                        "https://api.joylog.co.kr",
                        "http://localhost:3000",
                        "http://localhost:8080")
                .allowedMethods("*");
    }
}
