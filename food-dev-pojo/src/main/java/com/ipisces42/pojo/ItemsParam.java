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
    * 商品参数 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "items_param")
public class ItemsParam {
    /**
    * 商品参数id
    */
    @Schema(description="商品参数id")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 商品外键id
    */
    @Schema(description="商品外键id")
    private String itemId;

    /**
    * 产地 产地，例：中国江苏
    */
    @Schema(description="产地 产地，例：中国江苏")
    private String producPlace;

    /**
    * 保质期 保质期，例：180天
    */
    @Schema(description="保质期 保质期，例：180天")
    private String footPeriod;

    /**
    * 品牌名 品牌名，例：三只大灰狼
    */
    @Schema(description="品牌名 品牌名，例：三只大灰狼")
    private String brand;

    /**
    * 生产厂名 生产厂名，例：大灰狼工厂
    */
    @Schema(description="生产厂名 生产厂名，例：大灰狼工厂")
    private String factoryName;

    /**
    * 生产厂址 生产厂址，例：大灰狼生产基地
    */
    @Schema(description="生产厂址 生产厂址，例：大灰狼生产基地")
    private String factoryAddress;

    /**
    * 包装方式 包装方式，例：袋装
    */
    @Schema(description="包装方式 包装方式，例：袋装")
    private String packagingMethod;

    /**
    * 规格重量 规格重量，例：35g
    */
    @Schema(description="规格重量 规格重量，例：35g")
    private String weight;

    /**
    * 存储方法 存储方法，例：常温5~25°
    */
    @Schema(description="存储方法 存储方法，例：常温5~25°")
    private String storageMethod;

    /**
    * 食用方式 食用方式，例：开袋即食
    */
    @Schema(description="食用方式 食用方式，例：开袋即食")
    private String eatMethod;

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