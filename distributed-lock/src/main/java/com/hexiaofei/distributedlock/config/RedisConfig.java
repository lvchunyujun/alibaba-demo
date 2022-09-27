package com.hexiaofei.distributedlock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author lcyj
 * @date 2021-11-21 22:56
 * @since
 */
@Component
public class RedisConfig{

    private final static String REDIS_ADDR = "redis://192.168.124.100:6380";
    private final static String RED_REDIS_1 = "redis://192.168.124.100:6379";
    private final static String RED_REDIS_2 = "redis://192.168.124.100:6380";
    private final static String RED_REDIS_3 = "redis://192.168.124.100:6381";
    private final static String REDIS_PASSWORD = "000000";

    /**
     * redisson lock
     * mode: 哨兵模式
     * @return
     */
    @Bean(name="redissonSingle")
    public RedissonClient redissonSingle(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(REDIS_ADDR)
                .setPassword(REDIS_PASSWORD)
                .setConnectionPoolSize(200)
                .setConnectionMinimumIdleSize(70);
        return Redisson.create(config);
    }

//    @Bean(name="redissonSentinelServers")
//    public RedissonClient redissonSentinelServers(){
//        Config config = new Config();
//        config.useSentinelServers()
//                .addSentinelAddress(REDIS_MASTER)
//                .addSentinelAddress(REDIS_SLAVE_1)
//                .addSentinelAddress(REDIS_SLAVE_2)
//                .setPassword("REDIS_PASSWORD");
//
//        return Redisson.create(config);
//    }

    /**
     * RedLock-1
     * @return
     */
    @Primary
    @Bean(name="redissonRed1")
    public RedissonClient redissonRed1(){
        Config config = new Config();
        config.useSingleServer()
              .setAddress(RED_REDIS_1)
              .setPassword(REDIS_PASSWORD);
        return Redisson.create(config);
    }

    @Bean(name="redissonRed2")
    public RedissonClient redissonRed2(){
        Config config = new Config();
        config.useSingleServer()
              .setAddress(RED_REDIS_2)
              .setPassword(REDIS_PASSWORD);
        return Redisson.create(config);
    }

    @Bean(name="redissonRed3")
    public RedissonClient redissonRed3(){
        Config config = new Config();
        config.useSingleServer()
              .setAddress(RED_REDIS_3)
              .setPassword(REDIS_PASSWORD);
        return Redisson.create(config);
    }

}
