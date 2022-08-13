package io.john.amiscaray.videosharingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VideoSharingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoSharingDemoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer cors(){

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };

    }

}
