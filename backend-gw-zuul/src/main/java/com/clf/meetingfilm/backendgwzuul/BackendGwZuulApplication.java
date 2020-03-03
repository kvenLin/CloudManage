package com.clf.meetingfilm.backendgwzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class BackendGwZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendGwZuulApplication.class, args);
    }

}
