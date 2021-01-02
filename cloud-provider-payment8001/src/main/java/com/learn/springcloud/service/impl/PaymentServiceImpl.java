package com.learn.springcloud.service.impl;

import com.learn.springcloud.service.PaymentService;
import com.learn.springcloud.dao.PaymentDao;
import com.learn.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：wangzhikun
 * @Date：2020/12/19 15:48
 * @Desc：
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
