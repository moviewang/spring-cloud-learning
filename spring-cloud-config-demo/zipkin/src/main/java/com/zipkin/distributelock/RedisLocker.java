package com.zipkin.distributelock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:57
 */
@Component
public class RedisLocker implements DistributedLocker {
    private final static String LOCK_PREFIX  = "lock:";
    @Resource
    private RedissonConnector redissonConnector;

    @Override
    public <T> T lock(String name, AcquiredLockWorker<T> worker) throws UnableToAcquiredLockException, Exception {
        return lock(name, worker, 100);
    }

    @Override
    public <T> T lock(String name, AcquiredLockWorker<T> worker, int lockTime) throws UnableToAcquiredLockException, Exception {
        RedissonClient redissonClient = redissonConnector.getRedisson();
        RLock lock = redissonClient.getLock(LOCK_PREFIX + name);
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAcquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAcquiredLockException();
    }

    public void lock() {

    }
}
