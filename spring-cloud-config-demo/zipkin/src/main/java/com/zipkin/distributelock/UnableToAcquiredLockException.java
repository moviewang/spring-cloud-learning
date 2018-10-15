package com.zipkin.distributelock;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:50
 */
public class UnableToAcquiredLockException extends RuntimeException {
    public UnableToAcquiredLockException() {
    }

    public UnableToAcquiredLockException(String message) {
        super(message);
    }

    public UnableToAcquiredLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
