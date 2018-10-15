package com.zipkin.distributelock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: movie
 * @Date: 2018/10/14 18:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisLockerTest {
    @Resource
    private RedisLocker redisLocker;

    @Test
    public void lock() throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(start, done)).start();
        }
        start.countDown();
        done.await();
        System.out.println("all proccessor done, shutdown connection");
    }


    class Worker implements Runnable{
        private final CountDownLatch start;
        private final CountDownLatch done;

        public Worker(CountDownLatch start, CountDownLatch done) {
            this.start = start;
            this.done = done;
        }

        @Override
        public void run() {
            try {
                start.await();
                redisLocker.lock("test", new AcquiredLockWorker<Object>() {
                    @Override
                    public Object invokeAfterLockAcquire() throws Exception {
                        doTask();
                        return null;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doTask() {
            System.out.println(Thread.currentThread().getName() + " start");
            Random random = new Random();
            int randInt = random.nextInt(200);
            System.out.println(Thread.currentThread().getName() + "sleep" + randInt + "ms");
            try {
                TimeUnit.MILLISECONDS.sleep(randInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
            done.countDown();
        }
    }


}