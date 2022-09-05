package com.ipisces42.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户表 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class Users {
    /**
    * 主键id 用户id
    */
    @Schema(description="主键id 用户id")
    @TableId(type = IdType.AUTO)
    private String id;

    /**
    * 用户名 用户名
    */
    @Schema(description="用户名 用户名")
    private String username;

    /**
    * 密码 密码
    */
    @Schema(description="密码 密码")
    private String password;

    /**
    * 昵称 昵称
    */
    @Schema(description="昵称 昵称")
    private String nickname;

    /**
    * 真实姓名
    */
    @Schema(description="真实姓名")
    private String realname;

    /**
    * 头像
    */
    @Schema(description="头像")
    private String face;

    /**
    * 手机号 手机号
    */
    @Schema(description="手机号 手机号")
    private String mobile;

    /**
    * 邮箱地址 邮箱地址
    */
    @Schema(description="邮箱地址 邮箱地址")
    private String email;

    /**
    * 性别 性别 1:男  0:女  2:保密
    */
    @Schema(description="性别 性别 1:男  0:女  2:保密")
    private Integer sex;

    /**
    * 生日 生日
    */
    @Schema(description="生日 生日")
    private LocalDate birthday;

    /**
    * 创建时间 创建时间
    */
    @Schema(description="创建时间 创建时间")
    private LocalDateTime createdTime;

    /**
    * 更新时间 更新时间
    */
    @Schema(description="更新时间 更新时间")
    private LocalDateTime updatedTime;
}