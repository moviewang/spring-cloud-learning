package com.ribbon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Movie on 2018/4/2.
 */
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hello(String name) {
        return helloService.hi(name);
    }

}
