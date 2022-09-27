package com.hexiaofei.distributedlock.utils.lock;

import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *  Rad lock ：redis 集群节点锁
 * @author lcyj
 * @date 2021-11-28 17:07
 * @since
 */
@Service("redDistributedLock")
public class RedDistributedLock implements IDistributedLock {


    @Autowired
    @Qualifier(value="redissonRed1")
    RedissonClient redissonRed1;

    @Autowired
    @Qualifier(value="redissonRed2")
    RedissonClient redissonRed2;

    @Autowired
    @Qualifier(value="redissonRed3")
    RedissonClient redissonRed3;

    private final static int RED_LOCK_MAX_NUM = 3;

    @Override
    public void lock(String lockName) {
        RLock[] rLocks = this.getRLocks(lockName);
        RedissonRedLock redLock = new RedissonRedLock(rLocks);
        redLock.lock();
    }

    @Override
    public void unlock(String lockName) {
        RLock[] rLocks = this.getRLocks(lockName);
        RedissonRedLock redLock = new RedissonRedLock(rLocks);
        redLock.unlock();
    }

    private RLock[] getRLocks(String lockName){
        RLock[] rLocks = new RLock[RED_LOCK_MAX_NUM];
        RLock red1 = redissonRed1.getLock("RED-1:"+lockName);
        RLock red2 = redissonRed2.getLock("RED-2:"+lockName);
        RLock red3 = redissonRed3.getLock("RED-3:"+lockName);
        rLocks[0] = red1;
        rLocks[1] = red2;
        rLocks[2] = red3;
        return rLocks;
    }
}
