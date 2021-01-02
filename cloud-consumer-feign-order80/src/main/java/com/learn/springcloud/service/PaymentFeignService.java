package com.learn.springcloud.service;

import com.learn.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author：wangzhikun
 * @Date：2020/12/22 23:27
 * @Desc：
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) ;

    @GetMapping("/payment/feign/timeout")
    public String timeout();
}

