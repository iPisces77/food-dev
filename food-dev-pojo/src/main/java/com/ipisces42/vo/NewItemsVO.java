package com.ipisces42.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/8/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class NewItemsVO {
    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;
    private List<SimpleItemVO> simpleItemList;

   @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Validated
   public static class SimpleItemVO {
        private String itemId;
        private String itemName;
        private String itemUrl;
    }
}

