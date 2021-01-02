package com.learn.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author：wangzhikun
 * @Date：2020/12/25 0:00
 * @Desc：
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK...┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut...o(╥﹏╥)o";
    }
}
