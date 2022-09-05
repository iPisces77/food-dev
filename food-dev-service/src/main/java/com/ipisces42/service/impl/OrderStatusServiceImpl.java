package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.pojo.OrderStatus;
import com.ipisces42.mapper.OrderStatusMapper;
import com.ipisces42.service.OrderStatusService;
@Service
public class OrderStatusServiceImpl implements OrderStatusService{

    @Resource
    private OrderStatusMapper orderStatusMapper;

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderStatusMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderStatus record) {
        return orderStatusMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderStatus record) {
        return orderStatusMapper.insertSelective(record);
    }

    @Override
    public OrderStatus selectByPrimaryKey(String orderId) {
        return orderStatusMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderStatus record) {
        return orderStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderStatus record) {
        return orderStatusMapper.updateByPrimaryKey(record);
    }

}
