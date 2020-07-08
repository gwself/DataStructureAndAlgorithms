package com.yunus.limiting;

import lombok.Data;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoyunfeng
 * @Description: 令牌桶 限流算法
 * @date 2020/7/816:36
 */
public class TokenBucketRateLimit implements RateLimit, Runnable {

    /**
     * token 生成 速率 （每秒）
     */
    private Integer tokenLimitSecond;

    /**
     * 令牌桶队列
     */
    private BlockingQueue<String> tokenBucket;

    private static final String TOKEN = "__token__";

    private ScheduledExecutorService scheduledExecutorService;

    public TokenBucketRateLimit(Integer bucketSize, Integer tokenLimitSecond) {
        this.tokenLimitSecond = tokenLimitSecond;
        this.tokenBucket = new LinkedBlockingDeque<>(bucketSize);

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        long interval = (1000 * 1000 * 1000) / tokenLimitSecond;
        scheduledExecutorService.scheduleAtFixedRate(this, 0, interval, TimeUnit.NANOSECONDS);
    }

    @Override
    public boolean canPass() throws BlockException {
        String token = tokenBucket.poll();
        if (token == null || "".equals(token)) {
            throw new BlockException();
        }
        return true;
    }

    @Override
    public void run() {
        if (tokenBucket.remainingCapacity() == 0) {
            return;
        }
        tokenBucket.offer(TOKEN);
    }
}
