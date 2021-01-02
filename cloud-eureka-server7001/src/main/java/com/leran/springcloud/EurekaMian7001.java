package com.leran.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author：wangzhikun
 * @Date：2020/12/20 11:29
 * @Desc：
 */
@SpringBootApplication
@EnableEurekaServer//表明为注册中心服务
public class EurekaMian7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMian7001.class,args);
    }
}
