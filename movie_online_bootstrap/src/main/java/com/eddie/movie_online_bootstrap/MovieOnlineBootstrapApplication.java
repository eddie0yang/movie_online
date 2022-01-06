package com.eddie.movie_online_bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.eddie"})
@MapperScan(basePackages = {"com.eddie.**.mapper"})
public class MovieOnlineBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieOnlineBootstrapApplication.class, args);
    }

}
