package com.clf.meetingfilm.backendpracticeconsumer.service.impl;

import com.clf.meetingfilm.backendpracticeconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient client;

    @Override
    public String sayHello(String message) {
        //invoker provider test
//        String hostname = "localhost";
//        int port = 8201;
//        String uri = "/provider/sayhello?message=" + message;
//        String url = "http://" + hostname + ":" + port + uri;
        ServiceInstance choose = client.choose("hello-service-provider");
        String hostname = choose.getHost();
        int port = choose.getPort();
        String uri = "/provider/sayhello?message=" + message;
        String url = "http://" + hostname + ":" + port + uri;

        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
