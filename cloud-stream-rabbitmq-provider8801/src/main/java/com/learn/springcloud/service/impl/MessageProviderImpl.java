package com.learn.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.learn.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author：wangzhikun
 * @Date：2020/12/27 14:06
 * @Desc：
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = IdUtil.randomUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*************" + serial);

        return null;
    }
}
