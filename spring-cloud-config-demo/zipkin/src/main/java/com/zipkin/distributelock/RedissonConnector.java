package com.zipkin.distributelock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:52
 */
@Component
public class RedissonConnector {
    private RedissonClient redisson;

    @PostConstruct
    public void init() {
        redisson = Redisson.create();
    }

    public RedissonClient getRedisson() {
        return redisson;
    }
}
