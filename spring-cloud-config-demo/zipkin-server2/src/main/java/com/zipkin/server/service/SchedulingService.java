package com.zipkin.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: movie
 * @Date: 2018/10/4 12:24
 */
@Service
public class SchedulingService {
    private static final Logger log = LoggerFactory.getLogger(SchedulingService.class);
    @Resource
    private SleuthService sleuthService;

    @Scheduled(fixedDelay = 30000L)
    public void scheduleWork() throws InterruptedException {
        log.info("start schedule work");
        sleuthService.async();
        log.info("end schedule work");
    }
    
}
