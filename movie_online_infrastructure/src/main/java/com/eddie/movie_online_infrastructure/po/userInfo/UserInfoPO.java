package com.eddie.movie_online_infrastructure.po.userInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserInfoPO {

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "age")
    private int age;

    @TableField(value = "sex")
    private int sex;
}
