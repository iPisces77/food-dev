package com.ipisces42.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 商品评价表 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "items_comments")
public class ItemsComments {
    /**
    * id主键
    */
    @Schema(description="id主键")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 用户id 用户名须脱敏
    */
    @Schema(description="用户id 用户名须脱敏")
    private String userId;

    /**
    * 商品id
    */
    @Schema(description="商品id")
    private String itemId;

    /**
    * 商品名称
    */
    @Schema(description="商品名称")
    private String itemName;

    /**
    * 商品规格id 可为空
    */
    @Schema(description="商品规格id 可为空")
    private String itemSpecId;

    /**
    * 规格名称 可为空
    */
    @Schema(description="规格名称 可为空")
    private String specName;

    /**
    * 评价等级 1：好评 2：中评 3：差评
    */
    @Schema(description="评价等级 1：好评 2：中评 3：差评")
    private Integer commentLevel;

    /**
    * 评价内容
    */
    @Schema(description="评价内容")
    private String content;

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