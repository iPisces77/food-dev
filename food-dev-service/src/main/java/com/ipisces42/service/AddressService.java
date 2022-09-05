package com.ipisces42.service;

import com.ipisces42.pojo.UserAddress;
import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/9/5
 **/

public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     *
     * @param userId 用户id
     * @return
     */
    List<UserAddress> queryAll(String userId);
}
