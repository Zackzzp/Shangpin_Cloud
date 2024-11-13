package com.zack.cloud.feign.fallback;

import com.zack.cloud.feign.api.UserFeignClient;
import com.zack.cloud.model.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

@Slf4j
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User queryById(Long userId) {
        log.info("UserFeignClientFallback...queryById...方法执行了...");
        return new User();
    }
}
