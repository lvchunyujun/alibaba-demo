package com.hexiaofei.mygateway.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * JWT统一认证全局拦截器
 * @author lcyj
 * @date 2022-02-28 21:43
 * @since
 */
@Slf4j
@Component
public class JWTFilter implements Ordered,GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("#########JWTFilter############");
        return Mono.create(sink -> {
            sink.success();
        });
    }

    /**
     * 定义拦截器顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
