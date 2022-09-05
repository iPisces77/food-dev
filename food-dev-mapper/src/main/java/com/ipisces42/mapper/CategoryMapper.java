package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipisces42.dto.CategoryDTO;
import com.ipisces42.dto.NewItemsDTO;
import com.ipisces42.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Category record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Category record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Category record);

    List<CategoryDTO> getSubCatList(Integer rootCatId);

    List<NewItemsDTO> getSixNewItemsLazy(@Param("paramsMap")Map<String,Object> map);
}