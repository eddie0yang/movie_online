package com.eddie.movie_online_biz.userInfo.service.impl;

import com.eddie.movie_online_biz.userInfo.service.UserInfoService;
import com.eddie.movie_online_infrastructure.mapper.userInfo.UserInfoMapper;
import com.eddie.movie_online_infrastructure.po.UserInfoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void queryInfo() {
        List<UserInfoPO> userInfoPOS = userInfoMapper.queryInfo();
        for (UserInfoPO userInfoPO : userInfoPOS) {
            System.out.println(userInfoPO);
        }

    }
}
