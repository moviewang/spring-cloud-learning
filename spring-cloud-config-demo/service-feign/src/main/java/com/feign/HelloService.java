package com.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Movie on 2018/4/2.
 */
@FeignClient(value = "SERVER.HI")
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(String name);
}
