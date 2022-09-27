package com.hexiaofei.distributedlock.utils.lock;

/**
 * <br/>
 *
 * @author lcyj
 * @date 2021-11-21 22:39
 * @since
 */
public interface IDistributedLock {

    void lock(String lockName);

    void unlock(String lockName);
}
