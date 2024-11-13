package com.zack.cloud.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zack.cloud.model.entity.user.User;
import com.zack.cloud.user.config.PatternProperties;
import com.zack.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${pattern.dateformat}")
    private Pattern pattern;
    @Autowired
    private PatternProperties patternProperties;

    @SentinelResource("hot")
    @GetMapping(value = "/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId, @RequestHeader(name = "Truth") String header) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userService.findUserByUserId(userId);
    }

    // 修改用户数据端点
    @GetMapping(value = "/updateUserById")
    public String updateUserById() {
        return "修改用户数据成功";
    }

    @GetMapping(value = "/save")
    public String save() {
        userService.queryUsers();
        System.out.println("保存用户");
        return "订单保存成功";
    }

    @GetMapping(value = "/query")
    public String query() {
        userService.queryUsers();
        System.out.println("查询用户");
        return "查询用户成功";
    }


}
