package com.eddie.movie_online_infrastructure.sao.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ribbon-test")
public interface FeignTestApi {

    @GetMapping(value = "/ribbonTest/getUser2")
    String getUser(@RequestParam("id") int id);
}
