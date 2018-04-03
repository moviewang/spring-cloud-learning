package com.feign;

import com.feign.controller.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Movie on 2018/4/2.
 */
@FeignClient(value = "SERVER.HI", fallback = HelloServiceHystrix.class)
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam(value = "name") String name);
}
