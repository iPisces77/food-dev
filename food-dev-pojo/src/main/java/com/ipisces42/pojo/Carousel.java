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
 * 轮播图
 */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "carousel")
public class Carousel {

    /**
     * 主键
     */
    @Schema(description = "主键")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
     * 图片 图片地址
     */
    @Schema(description = "图片 图片地址")
    private String imageUrl;

    /**
     * 背景色
     */
    @Schema(description = "背景色")
    private String backgroundColor;

    /**
     * 商品id 商品id
     */
    @Schema(description = "商品id 商品id")
    private String itemId;

    /**
     * 商品分类id 商品分类id
     */
    @Schema(description = "商品分类id 商品分类id")
    private String catId;

    /**
     * 轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类
     */
    @Schema(description = "轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类")
    private Integer type;

    /**
     * 轮播图展示顺序
     */
    @Schema(description = "轮播图展示顺序")
    private Integer sort;

    /**
     * 是否展示
     */
    @Schema(description = "是否展示")
    private Integer isShow;

    /**
     * 创建时间 创建时间
     */
    @Schema(description = "创建时间 创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间 更新
     */
    @Schema(description = "更新时间 更新")
    private LocalDateTime updateTime;
}