package com.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Movie on 2018/4/2.
 */
@RestController
@RequestMapping("")
public class EurekaController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("hi")
    public String eureka(String name) {
        return "hi " + name + ", i am from port" + port;
    }

}
