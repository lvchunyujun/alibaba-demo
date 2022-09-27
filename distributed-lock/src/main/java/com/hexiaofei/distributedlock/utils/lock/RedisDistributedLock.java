package com.hexiaofei.distributedlock.utils.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Redisson lock : redis单节点锁
 * @author lcyj
 * @date 2021-11-21 22:40
 * @since
 */
@Service("redisDistributedLock")
public class RedisDistributedLock implements IDistributedLock {

    @Autowired
    @Qualifier(value="redissonSingle")
    RedissonClient redisson;

    @Override
    public void lock(String lockName) {
        RLock rLock = redisson.getLock(lockName);
        rLock.lock();
    }

    @Override
    public void unlock(String lockName) {
        RLock rLock = redisson.getLock(lockName);
        rLock.unlock();
    }
}
