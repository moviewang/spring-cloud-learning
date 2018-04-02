package com.ribbon;

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

    public String hi(String name) {
        return restTemplate.getForObject("http://SERVER.HI/hi?name=" + name, String.class);
    }

}
