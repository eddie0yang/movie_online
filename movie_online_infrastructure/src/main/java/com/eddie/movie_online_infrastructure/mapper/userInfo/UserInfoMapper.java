package com.eddie.movie_online_infrastructure.mapper.userInfo;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eddie.movie_online_infrastructure.po.userInfo.UserInfoPO;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfoPO> {

    List<UserInfoPO> queryInfo();

    default List<UserInfoPO> queryInfoByMyself(int a){
        LambdaQueryWrapper<UserInfoPO> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(UserInfoPO::getId,a);
        return this.selectList(lambdaQuery);
    }
}
