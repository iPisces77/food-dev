package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipisces42.dto.ItemsSearchDTO;
import com.ipisces42.dto.ShoppingCartDTO;
import com.ipisces42.pojo.Items;
import com.ipisces42.vo.request.ItemsSearchByCatIdRequest;
import com.ipisces42.vo.request.ItemsSearchByKeywordsRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemsMapper extends BaseMapper<Items> {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Items record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Items record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Items selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Items record);

    Page<ItemsSearchDTO> searchItemsByKeywords(IPage<?> page, @Param("request") ItemsSearchByKeywordsRequest request);

    Page<ItemsSearchDTO> searchItemsByThirdCat(IPage<?> page, @Param("request") ItemsSearchByCatIdRequest request);

    List<ShoppingCartDTO> queryItemsBySpecIds(@Param("paramsList") List<String> specIds);
}