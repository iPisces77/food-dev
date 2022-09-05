package com.ipisces42.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipisces42.mapper.UserAddressMapper;
import com.ipisces42.pojo.UserAddress;
import com.ipisces42.service.UserAddressService;
@Service
public class UserAddressServiceImpl implements UserAddressService{

    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserAddress record) {
        return userAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(UserAddress record) {
        return userAddressMapper.insertSelective(record);
    }

    @Override
    public UserAddress selectByPrimaryKey(String id) {
        return userAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAddress record) {
        return userAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAddress record) {
        return userAddressMapper.updateByPrimaryKey(record);
    }

}
