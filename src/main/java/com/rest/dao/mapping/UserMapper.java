package com.rest.dao.mapping;

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
    UserModel getUserById(String userId);
}
