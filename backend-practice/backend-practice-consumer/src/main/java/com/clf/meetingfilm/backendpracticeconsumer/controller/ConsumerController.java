package com.clf.meetingfilm.backendpracticeconsumer.controller;

import com.clf.meetingfilm.backendpracticeconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer/sayhello")
    public String sayHello(String message) {
        return consumerService.sayHello(message);
    }
}
