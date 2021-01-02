package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：wangzhikun
 * @Date：2020/12/23 23:51
 * @Desc：
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_global")
public class OrderController {

    @Resource
    private PaymentService paymentService;


    //    @HystrixCommand(fallbackMethod = "paymentInfo_handler")
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        return paymentService.paymentInfo_OK(id);
    }


    //    @HystrixCommand(fallbackMethod = "paymentInfo_handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        return paymentService.paymentInfo_TimeOut(id);
    }


    public String paymentInfo_handler(Integer id) {
        return "80服务不可以，请稍后再试...o(╥﹏╥)o...";
    }

    public String paymentInfo_global() {
        return "Global 。。。80服务不可以，请稍后再试...┭┮﹏┭┮...";
    }
}
