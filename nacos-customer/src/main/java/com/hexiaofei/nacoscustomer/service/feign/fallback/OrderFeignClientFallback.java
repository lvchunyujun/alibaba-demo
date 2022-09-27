package com.hexiaofei.nacoscustomer.service.feign.fallback;

import com.hexiaofei.nacoscustomer.service.feign.OrderFeignClient;
import org.springframework.stereotype.Component;

/**
 * 触发降级的实现类型
 * @author lcyj
 * @date 2022-03-17 22:21
 * @since
 */
@Component
public class OrderFeignClientFallback implements OrderFeignClient {

    @Override
    public String addOrder() {

        return "5XX: 服务触发降级！";
    }
}
