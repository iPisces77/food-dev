package com.ipisces42.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fuhaixin
 * @date 2022/9/5
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Long buyCounts;
    private Long priceDiscount;
    private Long priceNormal;
}
