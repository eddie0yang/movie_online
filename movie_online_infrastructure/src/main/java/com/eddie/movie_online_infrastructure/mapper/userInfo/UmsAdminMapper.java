package com.eddie.movie_online_infrastructure.mapper.userInfo;

import com.eddie.movie_online_infrastructure.po.userInfo.UmsAdminExample;
import com.eddie.movie_online_infrastructure.po.userInfo.UmsAdminPO;

import java.util.List;

public interface UmsAdminMapper {
//    long countByExample(UmsAdminExample example);
//
//    int deleteByExample(UmsAdminExample example);
//
//    int deleteByPrimaryKey(Long id);
//
    int insert(UmsAdminPO record);
//
//    int insertSelective(UmsAdmin record);

    List<UmsAdminPO> selectByExample(UmsAdminExample example);

//    UmsAdmin selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);
//
//    int updateByExample(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);
//
//    int updateByPrimaryKeySelective(UmsAdmin record);
//
//    int updateByPrimaryKey(UmsAdmin record);
}