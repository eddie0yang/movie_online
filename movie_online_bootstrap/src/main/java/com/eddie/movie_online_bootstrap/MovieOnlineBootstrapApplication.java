package com.eddie.movie_online_bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mr.Yang
 */
@SpringBootApplication(scanBasePackages = {"com.eddie"})
@MapperScan(basePackages = {"com.eddie.**.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients("com.eddie")
public class MovieOnlineBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieOnlineBootstrapApplication.class, args);
    }
}
