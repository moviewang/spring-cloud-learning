package com.zipkin.server.configuration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import zipkin.server.*;

/**
 * @Author: movie
 * @Date: 2018/10/4 11:38
 */
@Configuration
@EnableAsync
@EnableScheduling
public class ThreadConfig extends AsyncConfigurerSupport implements SchedulingConfigurer {
    @Resource
    private BeanFactory beanFactory;

    @Override
    @Bean
    @Primary
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(1);
        threadPoolTaskExecutor.initialize();
        return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(scheduleExecutor());
    }

    @Bean(name = "scheduleExecutor", destroyMethod = "shutdown")
    public Executor scheduleExecutor() {
        return Executors.newScheduledThreadPool(1);
    }
}
