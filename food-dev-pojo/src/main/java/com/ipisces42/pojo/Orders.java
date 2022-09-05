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
    * 订单表;
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "orders")
public class Orders {
    /**
    * 订单主键;同时也是订单编号
    */
    @Schema(description="订单主键;同时也是订单编号")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 用户id
    */
    @Schema(description="用户id")
    private String userId;

    /**
    * 收货人快照
    */
    @Schema(description="收货人快照")
    private String receiverName;

    /**
    * 收货人手机号快照
    */
    @Schema(description="收货人手机号快照")
    private String receiverMobile;

    /**
    * 收货地址快照
    */
    @Schema(description="收货地址快照")
    private String receiverAddress;

    /**
    * 订单总价格
    */
    @Schema(description="订单总价格")
    private Integer totalAmount;

    /**
    * 实际支付总价格
    */
    @Schema(description="实际支付总价格")
    private Integer realPayAmount;

    /**
    * 邮费;默认可以为零，代表包邮
    */
    @Schema(description="邮费;默认可以为零，代表包邮")
    private Integer postAmount;

    /**
    * 支付方式
    */
    @Schema(description="支付方式")
    private Integer payMethod;

    /**
    * 买家留言
    */
    @Schema(description="买家留言")
    private String leftMsg;

    /**
    * 扩展字段
    */
    @Schema(description="扩展字段")
    private String extand;

    /**
    * 买家是否评价;1：已评价，0：未评价
    */
    @Schema(description="买家是否评价;1：已评价，0：未评价")
    private Integer isComment;

    /**
    * 逻辑删除状态;1: 删除 0:未删除
    */
    @Schema(description="逻辑删除状态;1: 删除 0:未删除")
    private Integer isDelete;

    /**
    * 创建时间（成交时间）
    */
    @Schema(description="创建时间（成交时间）")
    private LocalDateTime createdTime;

    /**
    * 更新时间
    */
    @Schema(description="更新时间")
    private LocalDateTime updatedTime;
}