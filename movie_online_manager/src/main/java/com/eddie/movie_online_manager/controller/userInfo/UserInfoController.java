package com.eddie.movie_online_manager.controller.userInfo;

import com.eddie.movie_online_biz.userInfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户信息管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/test")
    @ApiOperation("测试用例")
    public String test(){
         userInfoService.queryInfo();
        return "123";
    }
}
