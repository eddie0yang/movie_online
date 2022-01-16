package com.eddie.movie_online_biz.userInfo.service.impl;


import com.eddie.movie_online_biz.dto.userInfo.UmsAdminDTO;
import com.eddie.movie_online_biz.dto.userInfo.UmsPermissionDTO;
import com.eddie.movie_online_biz.userInfo.service.UmsAdminService;
import com.eddie.movie_online_common.util.JwtTokenUtil;
import com.eddie.movie_online_infrastructure.mapper.userInfo.UmsAdminMapper;
import com.eddie.movie_online_infrastructure.mapper.userInfo.UmsAdminRoleRelationDao;
import com.eddie.movie_online_infrastructure.po.userInfo.UmsAdminExample;
import com.eddie.movie_online_infrastructure.po.userInfo.UmsAdminPO;
import com.eddie.movie_online_infrastructure.po.userInfo.UmsPermissionPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UmsAdminService实现类
 * Created by eddie on 2022/01/16
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

   @Override
    public UmsAdminDTO getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdminPO> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            UmsAdminPO umsAdminPO = adminList.get(0);
            UmsAdminDTO umsAdminModel = new UmsAdminDTO();
            BeanUtils.copyProperties(umsAdminPO,umsAdminModel);
            return umsAdminModel;
        }
        return null;
    }

    @Override
    public UmsAdminDTO register(UmsAdminDTO umsAdminParam) {
        UmsAdminPO umsAdminPO = new UmsAdminPO();
        BeanUtils.copyProperties(umsAdminParam, umsAdminPO);
        umsAdminPO.setCreateTime(new Date());
        umsAdminPO.setStatus(1);
        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdminPO.getUsername());
        List<UmsAdminPO> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdminPO.getPassword());
        umsAdminPO.setPassword(encodePassword);
        adminMapper.insert(umsAdminPO);
        UmsAdminDTO umsAdminDTO = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdminPO,umsAdminDTO);
        return umsAdminDTO;
    }

    @Override
    public List<UmsPermissionDTO> getPermissionList(Long adminId) {
        List<UmsPermissionPO> permissionList = adminRoleRelationDao.getPermissionList(adminId);
        List<UmsPermissionDTO> list = new ArrayList<>();
        for (UmsPermissionPO umsPermissionPO : permissionList) {
            UmsPermissionDTO umsPermission = new UmsPermissionDTO();
            BeanUtils.copyProperties(umsPermissionPO,umsPermission);
            list.add(umsPermission);
        }
        return list;
    }


}