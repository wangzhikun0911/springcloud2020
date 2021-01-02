package com.learn.springcloud.service;

import com.learn.springcloud.entities.Payment;

/**
 * @Author：wangzhikun
 * @Date：2020/12/19 15:47
 * @Desc：
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
