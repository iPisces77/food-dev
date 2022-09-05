package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipisces42.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddressMapper  extends BaseMapper<UserAddress> {
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
    int insert(UserAddress record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserAddress record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserAddress selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserAddress record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserAddress record);
}