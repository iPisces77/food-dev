package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipisces42.pojo.ItemsParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemsParamMapper  extends BaseMapper<ItemsParam> {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ItemsParam record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ItemsParam record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ItemsParam selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ItemsParam record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ItemsParam record);
}