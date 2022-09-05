package com.ipisces42.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ipisces42.mapper.UserAddressMapper;
import com.ipisces42.pojo.UserAddress;
import com.ipisces42.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuhaixin
 * @date 2022/9/5
 **/
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 根据用户id查询用户的收货地址列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public List<UserAddress> queryAll(String userId) {
        var userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.selectList(
            new LambdaQueryWrapper<UserAddress>().eq(UserAddress::getUserId, userId));
    }
}
