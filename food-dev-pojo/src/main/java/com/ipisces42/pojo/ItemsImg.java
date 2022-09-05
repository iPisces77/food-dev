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
    * 商品图片 
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "items_img")
public class ItemsImg {
    /**
    * 图片主键
    */
    @Schema(description="图片主键")
    @TableId(type = IdType.AUTO)

    private String id;

    /**
    * 商品外键id 商品外键id
    */
    @Schema(description="商品外键id 商品外键id")
    private String itemId;

    /**
    * 图片地址 图片地址
    */
    @Schema(description="图片地址 图片地址")
    private String url;

    /**
    * 顺序 图片顺序，从小到大
    */
    @Schema(description="顺序 图片顺序，从小到大")
    private Integer sort;

    /**
    * 是否主图 是否主图，1：是，0：否
    */
    @Schema(description="是否主图 是否主图，1：是，0：否")
    private Integer isMain;

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