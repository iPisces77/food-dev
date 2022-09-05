package com.ipisces42.controller;

import com.ipisces42.bo.UserLoginBO;
import com.ipisces42.bo.UserRegisterBO;
import com.ipisces42.service.UsersService;
import com.ipisces42.utils.IMOOCJSONResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

/**
 * @author fuhaixin
 * @date 2022/8/17
 **/
@Tag(name = "用户接口")
@RestController
@RequestMapping("/passport")
@Validated
public class PassportController {

    private final UsersService usersService;

    public PassportController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/usernameIsExist")
    @Operation(summary = "用户名是否存在", description = "用户名是否存在", method = "GET")
    public IMOOCJSONResult usernameIsExist(@NotEmpty(message = "用户名不能为空") @RequestParam("username") String username) {
        var isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        // 请求成功,用户名没有重复
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "用户注册", method = "POST")
    public IMOOCJSONResult register(@RequestBody @Valid UserRegisterBO userRegisterBO) {
        if (!Objects.equals(userRegisterBO.getPassword(), userRegisterBO.getConfirmPassword())) {
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        if (usersService.queryUsernameIsExist(userRegisterBO.getUsername())) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        usersService.createUser(userRegisterBO);
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录", method = "POST")
    public IMOOCJSONResult login(@RequestBody @Valid UserLoginBO userLoginBO) {
        var users = usersService.queryUserForLogin(userLoginBO.getUsername(), userLoginBO.getPassword());
        if (Objects.isNull(users)) {
            return IMOOCJSONResult.errorMsg("用户名或密码错误");
        }
        return IMOOCJSONResult.ok(users);
    }

    @PostMapping("/loginouy")
    @Operation(summary = "用户退出登录", description = "用户退出登录", method = "POST")
    public IMOOCJSONResult logout(@RequestParam String userId) {
        usersService.logout(userId);
        return IMOOCJSONResult.ok();
    }


}
