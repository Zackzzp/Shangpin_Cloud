package com.zack.cloud.user.controller;


import com.zack.cloud.model.entity.user.User;
import com.zack.cloud.user.config.PatternProperties;
import com.zack.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${pattern.dateformat}")
    private Pattern pattern;
    @Autowired
    private PatternProperties patternProperties;

    @GetMapping(value = "/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId, @RequestHeader(name = "Truth") String header) {
        return userService.findUserByUserId(userId);
    }

}
