package com.movie.ribbon.controller;

import com.movie.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: movie
 * @Date: 2018/10/6 17:03
 */
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping("/hi")
    public String hi() {
        return helloService.hi();
    }
}
