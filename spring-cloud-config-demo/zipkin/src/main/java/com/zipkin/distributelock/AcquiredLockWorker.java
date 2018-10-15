package com.zipkin.distributelock;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:46
 */
public interface AcquiredLockWorker<T> {
    T invokeAfterLockAcquire() throws Exception;
}
