package com.test.demo02_springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test"})
@MapperScan(basePackages = {"com.test.*.dao","com.test.*.mapper"})
public class Demo02SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo02SpringsecurityApplication.class, args);
    }

}
