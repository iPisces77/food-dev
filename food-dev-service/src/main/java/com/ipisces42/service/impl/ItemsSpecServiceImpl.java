package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.pojo.ItemsSpec;
import com.ipisces42.mapper.ItemsSpecMapper;
import com.ipisces42.service.ItemsSpecService;
@Service
public class ItemsSpecServiceImpl implements ItemsSpecService{

    @Resource
    private ItemsSpecMapper itemsSpecMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return itemsSpecMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ItemsSpec record) {
        return itemsSpecMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemsSpec record) {
        return itemsSpecMapper.insertSelective(record);
    }

    @Override
    public ItemsSpec selectByPrimaryKey(String id) {
        return itemsSpecMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemsSpec record) {
        return itemsSpecMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemsSpec record) {
        return itemsSpecMapper.updateByPrimaryKey(record);
    }

}
