package com.learn.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author：wangzhikun
 * @Date：2020/12/23 23:13
 * @Desc：
 */
@Service
public class PaymentService {

    //成功
//    @HystrixCommand(fallbackMethod = "paymentInfo_handler")
    public String paymentInfo_OK(Integer id) {
//        int age = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }

    //失败
//    @HystrixCommand(fallbackMethod = "paymentInfo_handler", commandProperties = {
//            //3秒钟以内就是正常的业务逻辑,超过3秒钟就会超时走兜底方法
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间窗口
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸，开启断路器
        })
        public String paymentCircuitBreaker(Integer id) {
            if (id < 0) {
                throw new RuntimeException("*****id 不能负数");
            }
            String serialNumber = IdUtil.simpleUUID();

            return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;

    }


    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }

    public String paymentInfo_handler(Integer id) {
        return "8001服务不可以，请稍后再试...o(╥﹏╥)o";
    }


}
