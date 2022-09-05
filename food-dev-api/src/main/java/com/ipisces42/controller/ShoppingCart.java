package com.ipisces42.controller;

import com.ipisces42.bo.ShoppingCartBO;
import com.ipisces42.service.ItemsService;
import com.ipisces42.utils.IMOOCJSONResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Tag(
        name = "ShoppingCart", description = "购物车接口相关API"
)
@RequestMapping("/shopcart")
@RestController
public class ShoppingCart {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ItemsService itemsService;

    @Operation(summary = "添加商品到购物车", description = "添加商品到购物车", method = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(@Valid @NotBlank(message = "用户id不能为空") @RequestParam("userId") String userId, @RequestBody ShoppingCartBO shoppingCartBO) {
//Todo 前端用户在登录的情况下,添加商品到购物车,会同时在后端同步购物车到redus缓存
        return IMOOCJSONResult.ok();
    }


}

