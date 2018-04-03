package com.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Movie on 2018/4/2.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name) {
        return restTemplate.getForObject("http://SERVER.HI/hi?name=" + name, String.class);
    }

    private String hiError(String name) {
        return "h1 sorry error!";
    }

}
