package com.learn.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：wangzhikun
 * @Date：2020/12/22 19:38
 * @Desc：
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();//随机
    }
}
