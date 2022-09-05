package com.ipisces42.service;

import com.ipisces42.bo.UserRegisterBO;
import com.ipisces42.pojo.Users;

public interface UsersService {


    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 判断用户名是否存在
     */

    boolean queryUsernameIsExist(String username);

    /**
     * 用户名注册
     */
    Users createUser(UserRegisterBO user);

    /**
     * 检索用户名和密码是否匹配,用于登录
     */
    Users queryUserForLogin(String username, String password);

    /**
     * 根据用户ID退出登录
     * @param userId 用户ID
     */
    void logout(String userId);
}
