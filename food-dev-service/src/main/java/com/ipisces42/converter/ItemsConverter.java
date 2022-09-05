package com.ipisces42.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipisces42.dto.ItemsCommentDTO;
import com.ipisces42.dto.ItemsSearchDTO;
import com.ipisces42.dto.ShoppingCartDTO;
import com.ipisces42.vo.ItemsCommentVO;
import com.ipisces42.vo.ItemsSearchVO;
import com.ipisces42.vo.ShoppingCartVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Mapper(componentModel = "spring")
public interface ItemsConverter {
    ItemsCommentVO dto2VO(ItemsCommentDTO dto);

    List<ItemsCommentVO> dto2VO(List<ItemsCommentDTO> dotList);

    @Mapping(target = "optimizeJoinOfCountSql", ignore = true)
    Page<ItemsCommentVO> itemsCommentPage2VO(Page<ItemsCommentDTO> dtoPage);


    @Mapping(target = "optimizeJoinOfCountSql", ignore = true)
    Page<ItemsSearchVO> itemsSearchPage2VO(Page<ItemsSearchDTO> dtoPage);

    ShoppingCartVO shoppingCartDto2VO(ShoppingCartDTO dto);

    List<ShoppingCartVO> shoppingCartDto2VO(List<ShoppingCartDTO> dtoList);
}
