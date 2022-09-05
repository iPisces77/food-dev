package com.ipisces42.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ipisces42.converter.CategoryConverter;
import com.ipisces42.mapper.CategoryMapper;
import com.ipisces42.pojo.Category;
import com.ipisces42.service.CategoryService;
import com.ipisces42.vo.CategoryVO;
import com.ipisces42.vo.NewItemsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryConverter categoryConverter;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有一级分类列表
     *
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {

        return categoryMapper.selectList(new LambdaQueryWrapper<Category>().eq(Category::getType, 1));
    }

    /**
     * 根据一级分类信息查询子分类信息
     *
     * @param rootCatId
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> querySubCatList(Integer rootCatId) {
        var subCatList = categoryMapper.getSubCatList(rootCatId);
        return categoryConverter.dto2VO(subCatList);
    }

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryConverter(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        var map = new HashMap<String, Object>();
        map.put("rootCatId", rootCatId);
        var sixNewItemsLazy = categoryMapper.getSixNewItemsLazy(map);
        return categoryConverter.itemDTO2VO(sixNewItemsLazy);
    }
}
