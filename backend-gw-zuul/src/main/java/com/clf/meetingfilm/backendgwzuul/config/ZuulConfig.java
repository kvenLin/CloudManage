package com.clf.meetingfilm.backendgwzuul.config;

import com.clf.meetingfilm.backendgwzuul.filters.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: clf
 * @Date: 2020-03-02
 * @Description: TODO
 */
@Configuration
public class ZuulConfig {

    @Bean
    public MyFilter initialMyFilter() {
        return new MyFilter();
    }
}
