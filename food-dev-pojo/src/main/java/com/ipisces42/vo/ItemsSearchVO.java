package com.ipisces42.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于展示商品搜索结果的VO
 *
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsSearchVO {
    private String itemId;
    private String itemName;
    private Long sellCounts;
    private String imgUrl;
    private Long price;
}
