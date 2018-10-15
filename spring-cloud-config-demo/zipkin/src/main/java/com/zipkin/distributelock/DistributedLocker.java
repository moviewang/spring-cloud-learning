package com.zipkin.distributelock;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:48
 */
public interface DistributedLocker {
    <T> T lock(String name, AcquiredLockWorker<T> worker) throws UnableToAcquiredLockException, Exception;
    <T> T lock(String name, AcquiredLockWorker<T> worker, int lockTime) throws UnableToAcquiredLockException, Exception;
}
