package com.movie.feign.feignservice.service;

import org.springframework.stereotype.Component;

/**
 * @Author: movie
 * @Date: 2018/10/6 18:22
 */
@Component
public class HiServiceHystrix implements HiService {
    public String hi() {
        return "hi Error!";
    }
}
