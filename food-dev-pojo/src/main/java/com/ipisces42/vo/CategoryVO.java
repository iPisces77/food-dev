package com.ipisces42.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/8/19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class CategoryVO {
    private Integer id;
    private String name;
    private Integer type;
    private Integer fatherId;
    private List<SubCategoryVO> subCatList;
}
