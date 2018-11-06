package com.rest.service.impl;

import com.rest.dao.UserDao;
import com.rest.dao.mapping.UserMapper;
import com.rest.model.UserModel;
import com.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
//    @Resource
//    private UserDao userDao;//注入dao


    @Resource
    private UserMapper userMapper;//注入dao

    @Override
    public void addUser(UserModel user) {
        System.out.println("============userDao===========" + userMapper);
        userMapper.addUser(user);
    }

    @Override
    public UserModel getUserById(String userId) {
//        return userDao.getUserById(userId);
        return null;
    }
}
