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
        //mybatis
        List<UserInfoPO> userInfoPOS = userInfoMapper.queryInfo();
        System.out.println("1"+userInfoPOS.toString());

        //mybatis plus
        UserInfoPO userInfoPO = userInfoMapper.selectById(1);
        System.out.println("2"+userInfoPO.toString());

        //mybatis plus + lambda
        List<UserInfoPO> userInfoPOS1 = userInfoMapper.queryInfoByMyself(1);
        System.out.println("3"+userInfoPOS1);
    }
}
