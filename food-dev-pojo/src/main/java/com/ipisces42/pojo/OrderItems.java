package com.ipisces42.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 订单商品关联表 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_items")
public class OrderItems {
    /**
    * 主键id
    */
    @Schema(description="主键id")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 归属订单id
    */
    @Schema(description="归属订单id")
    private String orderId;

    /**
    * 商品id
    */
    @Schema(description="商品id")
    private String itemId;

    /**
    * 商品图片
    */
    @Schema(description="商品图片")
    private String itemImg;

    /**
    * 商品名称
    */
    @Schema(description="商品名称")
    private String itemName;

    /**
    * 规格id
    */
    @Schema(description="规格id")
    private String itemSpecId;

    /**
    * 规格名称
    */
    @Schema(description="规格名称")
    private String itemSpecName;

    /**
    * 成交价格
    */
    @Schema(description="成交价格")
    private Integer price;

    /**
    * 购买数量
    */
    @Schema(description="购买数量")
    private Integer buyCounts;
}