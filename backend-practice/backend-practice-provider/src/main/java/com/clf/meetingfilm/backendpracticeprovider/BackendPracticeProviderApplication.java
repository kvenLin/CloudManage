package com.clf.meetingfilm.backendpracticeprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BackendPracticeProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPracticeProviderApplication.class, args);
    }

}
