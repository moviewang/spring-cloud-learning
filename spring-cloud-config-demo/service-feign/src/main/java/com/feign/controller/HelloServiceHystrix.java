package com.feign.controller;

import com.feign.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by Movie on 2018/4/2.
 */
@Component
public class HelloServiceHystrix implements HelloService{
    public String hi(String name) {
        return "sorry\t" + name ;
    }
}
