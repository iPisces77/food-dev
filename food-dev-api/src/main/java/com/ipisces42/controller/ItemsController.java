package com.ipisces42.controller;

import com.ipisces42.controller.base.BaseController;
import com.ipisces42.service.ItemsService;
import com.ipisces42.utils.IMOOCJSONResult;
import com.ipisces42.vo.ItemInfoVO;
import com.ipisces42.vo.request.ItemsCommentsRequest;
import com.ipisces42.vo.request.ItemsSearchByCatIdRequest;
import com.ipisces42.vo.request.ItemsSearchByKeywordsRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Tag(name = "商品接口", description = "商品信息展示的相关接口")
@RestController
@RequestMapping("/items")
@Validated
public class ItemsController extends BaseController {
    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @Operation(summary = "查询商品详情", description = "查询商品详情", method = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(@NotBlank(message = "商品id不能为空") @Parameter(name = "itemId", description = "商品id", required = true) @PathVariable("itemId") String itemId) {
        var items = itemsService.queryItemById(itemId);
        var itemsSpecs = itemsService.queryItemSpecList(itemId);
        var itemsParam = itemsService.queryItemParam(itemId);
        var itemsImgs = itemsService.queryItemImgList(itemId);
        var itemInfoVO = new ItemInfoVO(items, itemsImgs, itemsSpecs, itemsParam);
        return IMOOCJSONResult.ok(itemInfoVO);
    }

    @Operation(summary = "查询商品评价等级", description = "查询商品评价等级", method = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(@NotBlank(message = "商品id不能为空") @Parameter(name = "itemId", description = "商品id", required = true) @RequestParam("itemId") String itemId) {
        var commentLevelCountsVO = itemsService.queryCommentsCounts(itemId);
        return IMOOCJSONResult.ok(commentLevelCountsVO);
    }

    @Operation(summary = "查询商品评论", description = "查询商品评论", method = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult comments(@Valid ItemsCommentsRequest request) {

        var pagedGridResult = itemsService.queryPagedComments(request);
        return IMOOCJSONResult.ok(pagedGridResult);
    }

    @Operation(summary = "搜索商品列表", description = "搜索商品列表", method = "GET")
    @GetMapping("/search")
    public IMOOCJSONResult search(@Valid ItemsSearchByKeywordsRequest request) {
        var pagedGridResult = itemsService.searchItemsByKeywords(request);
        return IMOOCJSONResult.ok(pagedGridResult);
    }


    @Operation(summary = "搜索商品列表", description = "搜索商品列表", method = "GET")
    @GetMapping("/catItems")
    public IMOOCJSONResult searchByCatId(@Valid ItemsSearchByCatIdRequest request) {
        var pagedGridResult = itemsService.searchItemsByCatId(request);
        return IMOOCJSONResult.ok(pagedGridResult);
    }

    @Operation(summary = "根据商品ids查找最新的商品数据", description = "根据商品ids查找最新的商品数据", method = "GET")
    @GetMapping("/refresh")
    public IMOOCJSONResult refresh(@Valid @NotBlank(message = "商品ids不能为空") @Parameter(name = "itemSpecIds", description = "拼接的ids字符串", required = true) @RequestParam("itemSpecIds") String itemSpecIds) {
        return IMOOCJSONResult.ok(itemsService.queryItemsBySpecIds(itemSpecIds));
    }

    @Operation(summary = "从购物车种删除商品", description = "从购物车中删除商品", method = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(@Parameter(name = "userId", description = "用户Id", required = true) @RequestParam("userId") String userId, @Parameter(name = "itemSpecId", description = "商品规格Id") @RequestParam("itemSpecId") String itemSpecId) {
        //Todo 用户在页面伤处购物车中的商品数据,如果此时用户已经登录,则需要同步删除后端购物车中的数据
        return IMOOCJSONResult.ok();
    }
}
