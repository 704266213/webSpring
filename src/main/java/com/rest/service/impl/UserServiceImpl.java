package com.rest.service.impl;

import com.rest.dao.UserMapper;
import com.rest.model.UserModel;
import com.rest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */


    @Resource
    private UserMapper userMapper;//注入dao

    @Override
    public void addUser(UserModel user) {
        userMapper.addUser(user);
    }

    @Override
    public UserModel getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public UserModel login(UserModel userModel) {
        return userMapper.login(userModel);
    }

    @Override
    public void updateUserInfo(UserModel user) {
        userMapper.updateUserInfo(user);
    }
}
