package com.movie.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: movie
 * @Date: 2018/10/6 16:59
 */
@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi() {
        return restTemplate.getForObject("http://EUREKA-CLIENT-1/home", String.class);
    }

    public String hiError() {
        return "hi Error";
    }
}
