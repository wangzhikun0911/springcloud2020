package com.learn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author：wangzhikun
 * @Date：2020/12/22 22:02
 * @Desc：
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> instances);
}
