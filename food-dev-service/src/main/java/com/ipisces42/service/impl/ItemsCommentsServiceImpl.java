package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.pojo.ItemsComments;
import com.ipisces42.mapper.ItemsCommentsMapper;
import com.ipisces42.service.ItemsCommentsService;
@Service
public class ItemsCommentsServiceImpl implements ItemsCommentsService{

    @Resource
    private ItemsCommentsMapper itemsCommentsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return itemsCommentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ItemsComments record) {
        return itemsCommentsMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemsComments record) {
        return itemsCommentsMapper.insertSelective(record);
    }

    @Override
    public ItemsComments selectByPrimaryKey(String id) {
        return itemsCommentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemsComments record) {
        return itemsCommentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemsComments record) {
        return itemsCommentsMapper.updateByPrimaryKey(record);
    }

}
