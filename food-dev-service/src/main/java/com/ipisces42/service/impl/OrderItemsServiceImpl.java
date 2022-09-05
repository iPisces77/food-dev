package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.mapper.OrderItemsMapper;
import com.ipisces42.pojo.OrderItems;
import com.ipisces42.service.OrderItemsService;
@Service
public class OrderItemsServiceImpl implements OrderItemsService{

    @Resource
    private OrderItemsMapper orderItemsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return orderItemsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderItems record) {
        return orderItemsMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderItems record) {
        return orderItemsMapper.insertSelective(record);
    }

    @Override
    public OrderItems selectByPrimaryKey(String id) {
        return orderItemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItems record) {
        return orderItemsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItems record) {
        return orderItemsMapper.updateByPrimaryKey(record);
    }

}
