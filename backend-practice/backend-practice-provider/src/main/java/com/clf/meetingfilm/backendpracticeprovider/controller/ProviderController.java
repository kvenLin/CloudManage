package com.clf.meetingfilm.backendpracticeprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/provider/sayhello")
    public String providerSayHello(String message) {
        log.error("provider say hello, port: {}, message: {}", port, message);
        return "provider say hello";
    }
}
