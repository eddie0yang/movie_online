package com.eddie.movie_online_biz.userInfo.service;

import com.eddie.movie_online_biz.dto.userInfo.UmsAdminModel;
import com.eddie.movie_online_biz.dto.userInfo.UmsPermissionModel;

import java.util.List;

/**
 * 后台管理员Service
 * Created by eddie on 2022/01/16
 */
public interface UmsAdminService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdminModel getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermissionModel> getPermissionList(Long adminId);

    /**
     * 注册功能
     */
    UmsAdminModel register(UmsAdminModel umsAdminParam);
}