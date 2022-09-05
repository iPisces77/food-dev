package com.ipisces42.dto;

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
public class NewItemsDTO {
    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;
    private List<SimpleItemDTO> simpleItemList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Validated
    public static class SimpleItemDTO {
        private String itemId;
        private String itemName;
        private String itemUrl;
    }
}
