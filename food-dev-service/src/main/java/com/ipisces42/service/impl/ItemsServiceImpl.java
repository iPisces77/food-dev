package com.ipisces42.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipisces42.converter.ItemsConverter;
import com.ipisces42.dto.ItemsCommentDTO;
import com.ipisces42.dto.ItemsSearchDTO;
import com.ipisces42.enums.CommentLevel;
import com.ipisces42.mapper.*;
import com.ipisces42.pojo.*;
import com.ipisces42.service.ItemsService;
import com.ipisces42.utils.DesensitizationUtil;
import com.ipisces42.utils.PagedGridResult;
import com.ipisces42.vo.CommentLevelCountsVO;
import com.ipisces42.vo.ShoppingCartVO;
import com.ipisces42.vo.request.ItemsCommentsRequest;
import com.ipisces42.vo.request.ItemsSearchByCatIdRequest;
import com.ipisces42.vo.request.ItemsSearchByKeywordsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ItemsServiceImpl implements ItemsService {

    private final ItemsCommentsMapper itemsCommentsMapper;
    private ItemsMapper itemsMapper;
    private ItemsImgMapper itemsImgMapper;
    private ItemsSpecMapper itemsSpecMapper;
    private ItemsParamMapper itemsParamMapper;
    private final ItemsConverter itemsConverter;

    public ItemsServiceImpl(ItemsCommentsMapper itemsCommentsMapper, ItemsConverter itemsConverter) {
        this.itemsCommentsMapper = itemsCommentsMapper;
        this.itemsConverter = itemsConverter;
    }

    @Autowired
    public void setItemsMapper(ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }

    @Autowired
    public void setItemsImgMapper(ItemsImgMapper itemsImgMapper) {
        this.itemsImgMapper = itemsImgMapper;
    }

    @Autowired
    public void setItemsSpecMapper(ItemsSpecMapper itemsSpecMapper) {
        this.itemsSpecMapper = itemsSpecMapper;
    }

    @Autowired
    public void setItemsParamMapper(ItemsParamMapper itemsParamMapper) {
        this.itemsParamMapper = itemsParamMapper;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return itemsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Items record) {
        return itemsMapper.insert(record);
    }

    @Override
    public int insertSelective(Items record) {
        return itemsMapper.insertSelective(record);
    }

    @Override
    public Items selectByPrimaryKey(String id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Items record) {
        return itemsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Items record) {
        return itemsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Items record) {
        return itemsMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据商品ID查询详情
     *
     * @param itemId 商品ID
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Items queryItemById(String itemId) {
        return itemsMapper.selectOne(new LambdaQueryWrapper<Items>().eq(Items::getId, itemId));
    }

    /**
     * 根据商品ID查询商品图片列表
     *
     * @param itemId 商品ID
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        return itemsImgMapper.selectList(new LambdaQueryWrapper<ItemsImg>().eq(ItemsImg::getItemId, itemId));
    }

    /**
     * 根据商品ID查询商品规格
     *
     * @param itemId 商品ID
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        return itemsSpecMapper.selectList(new LambdaQueryWrapper<ItemsSpec>().eq(ItemsSpec::getItemId, itemId));
    }

    /**
     * 根据商品ID查询商品参数
     *
     * @param itemId 商品ID
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParam(String itemId) {
        return itemsParamMapper.selectOne(new LambdaQueryWrapper<ItemsParam>().eq(ItemsParam::getItemId, itemId));
    }

    /**
     * 根据商品id查询商品的平均等级数量
     *
     * @param itemId
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override

    public CommentLevelCountsVO queryCommentsCounts(String itemId) {
        var goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        var normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
        var badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        var totalCounts = getCommentCounts(itemId, null);
        return new CommentLevelCountsVO(totalCounts, goodCounts, normalCounts, badCounts);
    }

    /**
     * 根据商品id查询商品的评价(分页)
     *
     * @param request 包含商品id 和评价等级
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPagedComments(ItemsCommentsRequest request) {
        var commentDTOPage = new Page<ItemsCommentDTO>(request.getPage(), request.getPageSize());
        var itemsCommentDTOS = itemsCommentsMapper.queryItemComments(commentDTOPage, request);
        var collect = itemsCommentDTOS.getRecords().stream().map(item -> {
            item.setNickname(DesensitizationUtil.commonDisplay(item.getNickname()));
            return item;
        }).toList();
        var pagedGridResult = new PagedGridResult();

        var itemsCommentVOPage = itemsConverter.itemsCommentPage2VO(itemsCommentDTOS);
        pagedGridResult.setPage(itemsCommentVOPage.getCurrent());
        pagedGridResult.setRows(collect);
        pagedGridResult.setTotal(itemsCommentVOPage.getSize());
        pagedGridResult.setRecords(itemsCommentVOPage.getTotal());
        return pagedGridResult;

    }

    /**
     * 搜索产品列表
     *
     * @param request
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)

    @Override

    public PagedGridResult searchItemsByKeywords(ItemsSearchByKeywordsRequest request) {
        var itemsSearchDTOPage = new Page<ItemsSearchDTO>(request.getPage(), request.getPageSize());
        var itemsSearchDTOs = itemsMapper.searchItemsByKeywords(itemsSearchDTOPage, request);
        var itemsSearchVOPage = itemsConverter.itemsSearchPage2VO(itemsSearchDTOs);
        return buildPageGridResult(itemsSearchVOPage);

    }

    /**
     * 搜索产品列表
     *
     * @param request
     * @return
     */
    @Override
    public PagedGridResult searchItemsByCatId(ItemsSearchByCatIdRequest request) {
        var itemsSearchDTOPage = new Page<ItemsSearchDTO>(request.getPage(), request.getPageSize());
        var itemsSearchDTOs = itemsMapper.searchItemsByThirdCat(itemsSearchDTOPage, request);
        var itemsSearchVOPage = itemsConverter.itemsSearchPage2VO(itemsSearchDTOs);

        return buildPageGridResult(itemsSearchVOPage);
    }

    /**
     * 根据规格ids查询最新的购物车中商品数据(用于刷新渲染购物车中的商品数据)
     *
     * @param specIds 规格ids
     * @return
     */
    @Override
    public List<ShoppingCartVO> queryItemsBySpecIds(String specIds) {
        var ids = specIds.split(",");
        var specIdsList = List.of(ids);
        var shoppingCartDTOS = itemsMapper.queryItemsBySpecIds(specIdsList);
        return itemsConverter.shoppingCartDto2VO(shoppingCartDTOS);
    }

    /**
     * 获得不同评价等级下的评价条数
     *
     * @param itemId 产品id
     * @param level  评价等级
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCommentCounts(String itemId, Integer level) {
        return itemsCommentsMapper.selectCount(new LambdaQueryWrapper<ItemsComments>().eq(ItemsComments::getItemId, itemId).eq(Objects.nonNull(level), ItemsComments::getCommentLevel, level));
    }

    private PagedGridResult buildPageGridResult(Page<?> page) {
        var pagedGridResult = new PagedGridResult();
        pagedGridResult.setTotal(page.getSize());
        pagedGridResult.setRows(page.getRecords());
        pagedGridResult.setRecords(page.getTotal());
        pagedGridResult.setPage(page.getCurrent());
        return pagedGridResult;
    }

}
