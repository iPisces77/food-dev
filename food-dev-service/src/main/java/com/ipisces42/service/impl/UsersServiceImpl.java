package com.ipisces42.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipisces42.bo.UserRegisterBO;
import com.ipisces42.enums.Sex;
import com.ipisces42.exception.CustomException;
import com.ipisces42.mapper.UsersMapper;
import com.ipisces42.pojo.Users;
import com.ipisces42.service.UsersService;
import com.ipisces42.utils.CookieUtils;
import com.ipisces42.utils.JsonUtils;
import com.ipisces42.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {

    private static final String USER_FACE =
            "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";
    private Sid sid;

    private UsersMapper usersMapper;

    private HttpServletRequest request;

    private HttpServletResponse response;
    private ObjectMapper objectMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Autowired
    public void setSid(Sid sid) {
        this.sid = sid;
    }

    @Autowired
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    private Users setNullProperty(Users users) {
        users.setPassword(null);
        users.setMobile(null);
        users.setEmail(null);
        users.setCreatedTime(null);
        users.setBirthday(null);
        return users;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean queryUsernameIsExist(String username) {

        Users user = usersMapper.selectOne(new LambdaQueryWrapper<Users>().eq(Users::getUsername, username));
        return user != null;
    }

    /**
     * 用户名注册
     *
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserRegisterBO user) {
        Users users = new Users();
        users.setUsername(user.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 默认用户昵称同用户名
        users.setNickname(user.getUsername());
        // 默认头像
        users.setFace(USER_FACE);
        // 设置出生日期
        users.setBirthday(LocalDate.of(1900, 1, 1));
        // 设置性别
        users.setSex(Sex.SECRET.type);
        // 创建时间
        users.setCreatedTime(LocalDateTime.now());
        // 更新时间
        users.setUpdatedTime(LocalDateTime.now());
        // 设置ID
        users.setId(sid.nextShort());
        usersMapper.insert(users);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(setNullProperty(users)), true);

        //Todo 生成用户token,存入redis会话
        //Todo 同步购物车数据
        return users;
    }

    /**
     * 检索用户名和密码是否匹配,用于登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public Users queryUserForLogin(String username, String password) {
        Users users;
        try {
            users = usersMapper.selectOne(new LambdaQueryWrapper<Users>()
                    .eq(Users::getUsername, username)
                    .eq(Users::getPassword, MD5Utils.getMD5Str(password)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (Objects.isNull(users)) {
            throw new CustomException("用户名或密码错误");
        }
        try {
            CookieUtils.setCookie(request, response, "user", objectMapper.writeValueAsString(setNullProperty(users)), true);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        //Todo 生成用户token,存入redis会话
        //Todo 同步购物车数据
        return users;
    }

    /**
     * 根据用户ID退出登录
     *
     * @param userId 用户ID
     */
    @Override
    public void logout(String userId) {
        CookieUtils.deleteCookie(request, response, "user");

    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
