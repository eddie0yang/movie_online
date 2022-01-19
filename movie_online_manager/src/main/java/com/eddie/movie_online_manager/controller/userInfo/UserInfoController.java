package com.eddie.movie_online_manager.controller.userInfo;

import com.eddie.movie_online_biz.userInfo.service.UserInfoService;
import com.eddie.movie_online_common.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(tags = "用户信息管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/test")
    @ApiOperation("测试用例")
    public String test(){
        userInfoService.queryInfo();

        //redis测试
        redisService.set("abc","杨启文");
        String abc = redisService.get("abc");
        System.out.println(abc);
        return "SUCCESS";
    }

    @GetMapping(value = "/testRibbon")
    @ApiOperation("测试用例2")
    public String testRibbon(){
        return restTemplate.getForObject("http://ribbon-test/ribbonTest/123", String.class,"");
    }
}
