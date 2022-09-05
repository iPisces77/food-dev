package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.mapper.ItemsImgMapper;
import com.ipisces42.pojo.ItemsImg;
import com.ipisces42.service.ItemsImgService;
@Service
public class ItemsImgServiceImpl implements ItemsImgService{

    @Resource
    private ItemsImgMapper itemsImgMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return itemsImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ItemsImg record) {
        return itemsImgMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemsImg record) {
        return itemsImgMapper.insertSelective(record);
    }

    @Override
    public ItemsImg selectByPrimaryKey(String id) {
        return itemsImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemsImg record) {
        return itemsImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemsImg record) {
        return itemsImgMapper.updateByPrimaryKey(record);
    }

}
