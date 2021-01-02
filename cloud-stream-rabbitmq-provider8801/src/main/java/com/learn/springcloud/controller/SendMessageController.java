package com.learn.springcloud.controller;

import com.learn.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：wangzhikun
 * @Date：2020/12/27 14:15
 * @Desc：
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;


    @RequestMapping("/sendMessage")
    public String send(){
        return messageProvider.send();
    }
}
