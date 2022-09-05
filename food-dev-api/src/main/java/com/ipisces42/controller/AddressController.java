package com.ipisces42.controller;

import com.ipisces42.service.AddressService;
import com.ipisces42.utils.IMOOCJSONResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuhaixin
 * @date 2022/9/5
 **/
@Tag(name = "地址相关", description = "地址相关API接口")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 用户在确认订单页面,可以针对收货地址做如下操作: 1.查询用户的所有收货地址列表 2.新增收货地址 3.删除收货地址 4.修改收货地址 5.设置默认地址
     */
    @Operation(summary = "根据用户id查询收货地址列表", description = "根据用户id查询收货地址列表", method = "POST")
    @GetMapping("/list")
    public IMOOCJSONResult list(
        @Parameter(name = "userId", description = "用户id", required = true) @RequestParam("userId") String userId) {
        var userAddresses = addressService.queryAll(userId);
        return IMOOCJSONResult.ok(userAddresses);
    }
}
