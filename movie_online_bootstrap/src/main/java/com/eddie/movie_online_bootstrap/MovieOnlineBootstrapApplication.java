package com.eddie.movie_online_bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.eddie"})
@MapperScan(basePackages = {"com.eddie.**.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
//@EnableWebMvc
public class MovieOnlineBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieOnlineBootstrapApplication.class, args);
    }
}
