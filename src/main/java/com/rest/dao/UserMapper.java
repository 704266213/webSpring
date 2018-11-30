package com.rest.dao;

import com.rest.model.UserModel;

public interface UserMapper {

    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(UserModel user);

    /**
     * 根据用户id获取用户
     *
     * @param userId
     * @return
     */
    UserModel getUserById(int userId);

    /**
     * 根据用户id获取用户
     *
     * @param user
     * @return
     */
    UserModel login(UserModel user);
}
