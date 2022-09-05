package com.ipisces42.service;

import com.ipisces42.pojo.Category;
import com.ipisces42.vo.CategoryVO;
import com.ipisces42.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
     * 查询所有一级分类列表
     * @return
     */
    List<Category> queryAllRootLevelCat();
    /**
     *根据一级分类信息查询子分类信息
     */
    List<CategoryVO> querySubCatList(Integer rootCatId);
    /**
     * 查询每个一级分类下的最新6条商品数据
     *
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
