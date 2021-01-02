package com.learn.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.springcloud.entities.CommonResult;

/**
 * @Author：wangzhikun
 * @Date：2021/1/1 10:53
 * @Desc：
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler---1");

    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler---2");

    }

}
