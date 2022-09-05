package com.ipisces42.dto;

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
public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer type;
    private Integer fatherId;
    private List<SubCategoryDTO> subCatList;
}
