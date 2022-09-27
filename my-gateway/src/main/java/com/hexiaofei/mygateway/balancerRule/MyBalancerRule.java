package com.hexiaofei.mygateway.balancerRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 自定义负载均衡策略
 * @author lcyj
 * @date 2021-12-03 09:21
 * @since
 */
@Slf4j
public class MyBalancerRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        List<Server> list = this.getLoadBalancer().getReachableServers();
        Server server = list.get(0);
        log.info("LoaderBalanceer:"+server.getPort());
        return server;
    }
}
