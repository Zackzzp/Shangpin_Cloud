package com.zack.cloud.order.service.Impl;


import com.zack.cloud.feign.api.UserFeignClient;
import com.zack.cloud.model.entity.order.Order;
import com.zack.cloud.model.entity.user.User;
import com.zack.cloud.order.mapper.OrderMapper;
import com.zack.cloud.order.service.OrderService;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public Order findOrderByOrderId(Long orderId) {
        // 根据id查询订单数据
        Order order = orderMapper.findOrderByOrderId(orderId);

        // 发起远程调用
        User user = userFeignClient.queryById(order.getUserId());
        order.setUser(user);

        // 返回订单数据
        return order;
    }

}
