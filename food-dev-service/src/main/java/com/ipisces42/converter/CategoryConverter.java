package com.ipisces42.converter;

import com.ipisces42.dto.CategoryDTO;
import com.ipisces42.dto.NewItemsDTO;
import com.ipisces42.dto.SubCategoryDTO;
import com.ipisces42.vo.CategoryVO;
import com.ipisces42.vo.NewItemsVO;
import com.ipisces42.vo.SubCategoryVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryConverter {
    CategoryVO dto2VO(CategoryDTO dto);

    SubCategoryVO dto2VO(SubCategoryDTO dto);

    List<CategoryVO> dto2VO(List<CategoryDTO> dtoList);

    List<NewItemsVO> itemDTO2VO(List<NewItemsDTO> dtoList);


}