package com.ipisces42.service;

import com.ipisces42.pojo.Items;
import com.ipisces42.pojo.ItemsImg;
import com.ipisces42.pojo.ItemsParam;
import com.ipisces42.pojo.ItemsSpec;
import com.ipisces42.utils.PagedGridResult;
import com.ipisces42.vo.CommentLevelCountsVO;
import com.ipisces42.vo.ShoppingCartVO;
import com.ipisces42.vo.request.ItemsCommentsRequest;
import com.ipisces42.vo.request.ItemsSearchByCatIdRequest;
import com.ipisces42.vo.request.ItemsSearchByKeywordsRequest;

import java.util.List;

public interface ItemsService {

    int deleteByPrimaryKey(String id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);

    /**
     * 根据商品ID查询详情
     *
     * @param itemId 商品ID
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品ID查询商品图片列表
     *
     * @param itemId 商品ID
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品ID查询商品规格
     *
     * @param itemId 商品ID
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品ID查询商品参数
     *
     * @param itemId 商品ID
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品的平均等级数量
     *
     * @param itemId
     */
    CommentLevelCountsVO queryCommentsCounts(String itemId);

    /**
     * 根据商品id查询商品的评价(分页)
     *
     * @param request 查询条件包括产品id和评价等级
     * @return
     */
    PagedGridResult queryPagedComments(ItemsCommentsRequest request);

    /**
     * 搜索产品列表
     *
     * @param request
     * @return
     */
    PagedGridResult searchItemsByKeywords(ItemsSearchByKeywordsRequest request);

    /**
     * 搜索产品列表
     *
     * @param request
     * @return
     */
    PagedGridResult searchItemsByCatId(ItemsSearchByCatIdRequest request);

    /**
     * 根据规格ids查询最新的购物车中商品数据(用于刷新渲染购物车中的商品数据)
     *
     * @param specIds 规格ids
     * @return
     */
    List<ShoppingCartVO> queryItemsBySpecIds(String specIds);
}
