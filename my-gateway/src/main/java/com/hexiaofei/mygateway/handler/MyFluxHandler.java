package com.hexiaofei.mygateway.handler;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lcyj
 * @date 2022-03-04 17:34
 * @since
 */
@Configuration
public class MyFluxHandler {

//    @Bean
//    public RouteLocator routeLocator (RouteLocatorBuilder locatorBuilder) {
//
//        return locatorBuilder.routes()
//                .route(p ->
//                        p.path("/xxoo")
//                                .filters(f -> f.stripPrefix(1))
//                                .uri("https://www.baidu.com")
//                )
//                .route(p ->
//                        p.path("/go")
//                                .filters(f -> f.stripPrefix(1))
//                                .uri("lb://MDB")
//                )
//                .build();
//    }
}
