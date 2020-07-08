package com.yunus.limiting;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/7/816:36
 */
public class LeakyBucketRateLimit implements RateLimit, Runnable {

    /**
     * 出口限制qps
     */
    private Integer limitSecond;
    /**
     * 漏桶队列
     */
    private BlockingQueue<Thread> leakyBucket;

    private ScheduledExecutorService scheduledExecutorService;

    public LeakyBucketRateLimit(Integer bucketSize, Integer limitSecond) {
        this.limitSecond = limitSecond;
        this.leakyBucket = new LinkedBlockingDeque<>(bucketSize);

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        long interval = (1000 * 1000 * 1000) / limitSecond;
        scheduledExecutorService.scheduleAtFixedRate(this, 0, interval, TimeUnit.NANOSECONDS);
    }

    @Override
    public boolean canPass() throws BlockException {
        if (leakyBucket.remainingCapacity() == 0) {
            throw new BlockException();
        }
        leakyBucket.offer(Thread.currentThread());
        LockSupport.park();
        return true;
    }

    @Override
    public void run() {
        Thread thread = leakyBucket.poll();
        if (Objects.nonNull(thread)) {
            LockSupport.unpark(thread);
        }
    }
}