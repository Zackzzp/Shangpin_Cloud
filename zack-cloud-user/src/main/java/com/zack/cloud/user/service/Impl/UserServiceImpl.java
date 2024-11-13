package com.zack.cloud.user.service.Impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zack.cloud.model.entity.user.User;
import com.zack.cloud.user.mapper.UserMapper;
import com.zack.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserId(Long userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    @SentinelResource("users")
    public void queryUsers() {
        System.err.println("查询用户");
    }
}
