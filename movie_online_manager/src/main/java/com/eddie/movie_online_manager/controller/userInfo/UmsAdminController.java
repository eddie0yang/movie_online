package com.eddie.movie_online_manager.controller.userInfo;

import com.eddie.movie_online_api.dto.userInfo.UmsAdminDTO;
import com.eddie.movie_online_api.dto.userInfo.UmsAdminLoginDTO;
import com.eddie.movie_online_api.dto.userInfo.UmsPermissionDTO;
import com.eddie.movie_online_biz.dto.userInfo.UmsAdminModel;
import com.eddie.movie_online_biz.dto.userInfo.UmsPermissionModel;
import com.eddie.movie_online_biz.userInfo.service.UmsAdminService;
import com.eddie.movie_online_common.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * Created by eddie on 2022/01/16
 */
@Controller
@Api(tags = "后台用户管理", description = "UmsAdminController")
@RequestMapping("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginDTO umsAdminLoginDTO) {
        String token = adminService.login(umsAdminLoginDTO.getUsername(), umsAdminLoginDTO.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdminDTO> register(@RequestBody UmsAdminDTO umsAdminDTO) {
        UmsAdminModel umsAdminModel = new UmsAdminModel();
        BeanUtils.copyProperties(umsAdminDTO,umsAdminModel);
        UmsAdminModel umsAdmin = adminService.register(umsAdminModel);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        UmsAdminDTO umsAdminDTO2 = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdminModel,umsAdminDTO2);
        return CommonResult.success(umsAdminDTO2);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermissionDTO>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermissionModel> permissionList = adminService.getPermissionList(adminId);

        List<UmsPermissionDTO> list = new ArrayList<>();
        for (UmsPermissionModel umsPermissionModel : permissionList) {
            UmsPermissionDTO umsPermissionDTO = new UmsPermissionDTO();
            BeanUtils.copyProperties(umsPermissionModel,umsPermissionDTO);
            list.add(umsPermissionDTO);
        }
        return CommonResult.success(list);
    }
}