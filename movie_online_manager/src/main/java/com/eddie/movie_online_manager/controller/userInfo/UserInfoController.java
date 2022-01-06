package com.eddie.movie_online_manager.controller.userInfo;

import com.eddie.movie_online_biz.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/test")
    public String test(){

         userInfoService.queryInfo();
        return "123";
    }
}
