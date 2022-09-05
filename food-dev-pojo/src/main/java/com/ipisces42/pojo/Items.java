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
    * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "items")
public class Items {
    /**
    * 商品主键id
    */
    @Schema(description="商品主键id")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 商品名称 商品名称
    */
    @Schema(description="商品名称 商品名称")
    private String itemName;

    /**
    * 分类外键id 分类id
    */
    @Schema(description="分类外键id 分类id")
    private Integer catId;

    /**
    * 一级分类外键id
    */
    @Schema(description="一级分类外键id")
    private Integer rootCatId;

    /**
    * 累计销售 累计销售
    */
    @Schema(description="累计销售 累计销售")
    private Integer sellCounts;

    /**
    * 上下架状态 上下架状态,1:上架 2:下架
    */
    @Schema(description="上下架状态 上下架状态,1:上架 2:下架")
    private Integer onOffStatus;

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

    /**
    * 商品内容 商品内容
    */
    @Schema(description="商品内容 商品内容")
    private String content;
}