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
    * 商品分类 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category")
public class Category {
    /**
    * 主键
    */
    @Schema(description="主键")
    @TableId(type = IdType.AUTO)

    private Integer id;

    /**
    * 分类名称
    */
    @Schema(description="分类名称")
    private String name;

    /**
    * 分类类型
    */
    @Schema(description="分类类型")
    private Integer type;

    /**
    * 父id
    */
    @Schema(description="父id")
    private Integer fatherId;

    /**
    * 图标
    */
    @Schema(description="图标")
    private String logo;

    /**
    * 口号
    */
    @Schema(description="口号")
    private String slogan;

    /**
    * 分类图
    */
    @Schema(description="分类图")
    private String catImage;

    /**
    * 背景颜色
    */
    @Schema(description="背景颜色")
    private String bgColor;
}