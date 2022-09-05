package com.ipisces42.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "items_spec")
public class ItemsSpec {
    /**
    * 商品规格id
    */
    @Schema(description="商品规格id")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 商品外键id
    */
    @Schema(description="商品外键id")
    private String itemId;

    /**
    * 规格名称
    */
    @Schema(description="规格名称")
    private String name;

    /**
    * 库存
    */
    @Schema(description="库存")
    private Integer stock;

    /**
    * 折扣力度
    */
    @Schema(description="折扣力度")
    private BigDecimal discounts;

    /**
    * 优惠价
    */
    @Schema(description="优惠价")
    private Integer priceDiscount;

    /**
    * 原价
    */
    @Schema(description="原价")
    private Integer priceNormal;

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