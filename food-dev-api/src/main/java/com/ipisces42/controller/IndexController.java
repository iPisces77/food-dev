package com.ipisces42.controller;

import com.ipisces42.enums.YesOrNo;
import com.ipisces42.service.CarouselService;
import com.ipisces42.service.CategoryService;
import com.ipisces42.utils.IMOOCJSONResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author fuhaixin
 * @date 2022/8/18
 **/
@Tag(name = "首页接口", description = "首页展示的相关接口")
@RestController
@RequestMapping("/index")
@Validated
public class IndexController {
    private CarouselService carouselService;
    private CategoryService categoryService;

    @Autowired
    public void setCarouselService(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/carousel")
    @Operation(summary = "获取首页轮播图列表", description = "获取首页轮播图列表", method = "GET")
    public IMOOCJSONResult carousels() {
        var carousels = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(carousels);
    }

    /**
     * 首页分类展示需求:
     * 1.第一次刷新主页查询大分类,渲染展示到首页
     * 2.点击大分类,查询小分类,渲染展示到首页
     */
    @GetMapping("/cats")
    @Operation(summary = "获取首页分类(一级分类)列表", description = "获取首页分类(一级分类)列表", method = "GET")
    public IMOOCJSONResult category() {
        var categories = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(categories);
    }

    @GetMapping("/subCat/{rootCatId}")
    @Operation(summary = "获取首页分类(二级分类||三级)列表", description = "获取首页分类(二级||三级分类)列表", method = "GET")
    public IMOOCJSONResult category(
            @NotNull(message = "分类id不能为空")
            @Parameter(name = "rootCatId", description = "一级分类Id")
            @PathVariable("rootCatId")
            Integer rootCatId) {
        var categoryVOS = categoryService.querySubCatList(rootCatId);
        return IMOOCJSONResult.ok(categoryVOS);
    }

    @GetMapping("/sixNewItems/{rootCatId}")
    @Operation(summary = "获取每个一级分类下的最新6条商品数据", description = "获取每个一级分类下的最新6条商品数据", method = "GET")
    public IMOOCJSONResult sixNewItems(
            @NotNull(message = "一级分类id不能为空")
            @Parameter(name = "rootCatId", description = "一级分类Id")
            @PathVariable("rootCatId")
            Integer rootCatId) {
        var categoryVOS = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(categoryVOS);
    }
}
