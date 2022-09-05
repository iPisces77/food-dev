package com.ipisces42.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户地址表 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_address")
public class UserAddress {
    /**
    * 地址主键id
    */
    @Schema(description="地址主键id")    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 关联用户id
    */
    @Schema(description="关联用户id")
    private String userId;

    /**
    * 收件人姓名
    */
    @Schema(description="收件人姓名")
    private String receiver;

    /**
    * 收件人手机号
    */
    @Schema(description="收件人手机号")
    private String mobile;

    /**
    * 省份
    */
    @Schema(description="省份")
    private String province;

    /**
    * 城市
    */
    @Schema(description="城市")
    private String city;

    /**
    * 区县
    */
    @Schema(description="区县")
    private String district;

    /**
    * 详细地址
    */
    @Schema(description="详细地址")
    private String detail;

    /**
    * 扩展字段
    */
    @Schema(description="扩展字段")
    private String extand;

    /**
    * 是否默认地址
    */
    @Schema(description="是否默认地址")
    private Integer isDefault;

    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private LocalDateTime createdTime;

    /**
    * 更新时间
    */
    @Schema(description="更新时间")
    private LocalDateTime updatedTime;
}