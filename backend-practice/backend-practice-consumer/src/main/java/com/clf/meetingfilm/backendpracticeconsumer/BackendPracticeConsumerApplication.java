package com.clf.meetingfilm.backendpracticeconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient //SpringCloud官方提供, 可以集成任何大部分的注册中心, 推荐使用
//@EnableEurekaClient //EnableEurekaClient和EnableDiscoveryClient功能基本相同, 但是只能对Eureka起作用
@SpringBootApplication
public class BackendPracticeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPracticeConsumerApplication.class, args);
    }

}
