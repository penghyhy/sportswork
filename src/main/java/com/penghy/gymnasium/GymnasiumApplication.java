package com.penghy.gymnasium;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.penghy.gymnasium.core.mapper")
public class GymnasiumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GymnasiumApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(this.getClass());
        return builder.sources(GymnasiumApplication.class);
    }
}
