package com.movie.feign.feignservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: movie
 * @Date: 2018/10/6 18:03
 */
@FeignClient(value = "eureka-client-1", fallback = HiServiceHystrix.class)
public interface HiService {
    @RequestMapping(value = "home", method = RequestMethod.GET)
    String hi();
}
