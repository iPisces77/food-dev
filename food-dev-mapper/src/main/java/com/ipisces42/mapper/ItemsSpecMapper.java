package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipisces42.pojo.ItemsSpec;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemsSpecMapper extends BaseMapper<ItemsSpec> {
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
    int insert(ItemsSpec record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ItemsSpec record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ItemsSpec selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ItemsSpec record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ItemsSpec record);
}