package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.mapper.ItemsParamMapper;
import com.ipisces42.pojo.ItemsParam;
import com.ipisces42.service.ItemsParamService;
@Service
public class ItemsParamServiceImpl implements ItemsParamService{

    @Resource
    private ItemsParamMapper itemsParamMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return itemsParamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ItemsParam record) {
        return itemsParamMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemsParam record) {
        return itemsParamMapper.insertSelective(record);
    }

    @Override
    public ItemsParam selectByPrimaryKey(String id) {
        return itemsParamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemsParam record) {
        return itemsParamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemsParam record) {
        return itemsParamMapper.updateByPrimaryKey(record);
    }

}
