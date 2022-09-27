package com.hexiaofei.nacoscustomer.service.feign;

import com.hexiaofei.nacoscustomer.service.feign.fallback.OrderFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lcyj
 * @date 2022-03-17 17:28
 * @since
 */
@Service
@FeignClient(value = "nacos-provider",fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/addOrder")
    public String addOrder();
}
