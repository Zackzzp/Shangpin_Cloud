package com.zack.cloud.user.service;


import com.zack.cloud.model.entity.user.User;

public interface UserService {
    // 根据用户的id查询用户详情
    public abstract User findUserByUserId(Long userId) ;

    public abstract  void queryUsers();
}
