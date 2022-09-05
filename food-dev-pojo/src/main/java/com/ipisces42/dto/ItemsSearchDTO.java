package com.ipisces42.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsSearchDTO {
    private String itemId;
    private String itemName;
    private Long sellCounts;
    private String imgUrl;
    private Long price;
}
