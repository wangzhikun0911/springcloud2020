package com.learn.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：wangzhikun
 * @Date：2020/12/26 14:11
 * @Desc：
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocator route = builder.routes().route("path_route", r -> r.path("/guonei").uri("http://news.baidu.com/guoji")).build();
        return route;
    }
}
