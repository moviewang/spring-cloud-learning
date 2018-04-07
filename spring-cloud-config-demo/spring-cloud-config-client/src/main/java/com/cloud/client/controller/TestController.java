package com.cloud.client.controller;

import com.cloud.client.constants.TestConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Movie on 2018/4/2.
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${test}")
    private String uat;

    @Resource
    private TestConfiguration testConfiguration;

    @RequestMapping("/test")
    public String test() {
        return testConfiguration.getFrom();
    }


    @RequestMapping("/uat")
    public String uat() {
        return uat;
    }
}
