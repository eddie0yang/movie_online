package com.eddie.movie_online_infrastructure.mapper.userInfo;


import com.eddie.movie_online_infrastructure.po.UserInfoPO;

import java.util.List;

public interface UserInfoMapper {

    List<UserInfoPO> queryInfo();
}
