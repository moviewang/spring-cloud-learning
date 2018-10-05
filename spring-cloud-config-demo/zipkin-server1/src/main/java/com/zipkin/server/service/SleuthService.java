package com.zipkin.server.service;

import brave.Span;
import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: movie
 * @Date: 2018/10/4 11:07
 */
@Service
public class SleuthService {
    private static final Logger log = LoggerFactory.getLogger(SleuthService.class);

    @Resource
    private Tracer tracer;

    public void doSomeWorkSpan() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("doing some work");
    }

    public void newSpan() throws InterruptedException {
        log.info("i am in the orginal span");
        Span newSpan = tracer.newTrace().name("newSpan").start();
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())){
            TimeUnit.SECONDS.sleep(1);
            log.info("I'm in new span doing some cool work");
        } finally {
            newSpan.finish();
        }
        log.info("I'm in the original span");
    }

    @Async
    public void async() throws InterruptedException {
        log.info("start async");
        TimeUnit.SECONDS.sleep(1);
        log.info("end async");
    }

}
