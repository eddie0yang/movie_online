package com.eddie.movie_online_infrastructure.mapper.userInfo;


import com.eddie.movie_online_infrastructure.po.userInfo.UmsPermissionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermissionPO> getPermissionList(@Param("adminId") Long adminId);
}
