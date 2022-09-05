package com.ipisces42.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @author fuhaixin
 * @date 2022/8/19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class SubCategoryDTO {
    private Integer subId;
    private String subName;
    private Integer subType;
    private Integer subFatherId;
}
