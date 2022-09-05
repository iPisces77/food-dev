package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipisces42.pojo.OrderStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderStatusMapper extends BaseMapper<OrderStatus> {
    /**
     * delete by primary key
     * @param orderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OrderStatus record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderStatus record);

    /**
     * select by primary key
     * @param orderId primary key
     * @return object by primary key
     */
    OrderStatus selectByPrimaryKey(String orderId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderStatus record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderStatus record);
}