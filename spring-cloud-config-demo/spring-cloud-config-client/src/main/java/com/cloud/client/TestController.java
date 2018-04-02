package com.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Movie on 2018/4/2.
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Value("${test}")
    private String info;

    @RequestMapping("test")
    public String test() {
        return info;
    }
}
