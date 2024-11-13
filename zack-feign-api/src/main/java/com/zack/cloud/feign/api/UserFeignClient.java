package com.zack.cloud.feign.api;


import com.zack.cloud.feign.fallback.UserFeignClientFallback;
import com.zack.cloud.model.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zack-cloud-user",fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    @GetMapping("/api/user/findUserByUserId/{userId}")
    public abstract User queryById(@PathVariable("userId") Long userId) ;	// 根据userId查询用户信息的接口方法
}
