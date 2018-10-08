package com.movie.feign.feignservice.controller;

import com.movie.feign.feignservice.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: movie
 * @Date: 2018/10/6 18:06
 */
@RestController
public class HiController {
    @Resource
    private HiService hiService;

    @GetMapping("/hi")
    public String hi() {
        return hiService.hi();
    }
}
