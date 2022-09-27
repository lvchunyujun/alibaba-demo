package com.hexiaofei.nacosdemo.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hexiaofei.nacosdemo.exceptions.ExceptionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcyj
 * @date 2021-11-20 12:29
 * @since
**/
@RestController
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @SentinelResource(value = "getServerPort", blockHandler = "handleException")
    @RequestMapping("getServerPort")
    public String getServerPort(){
        return serverPort;
    }

    public String handleException(BlockException blcokException){
        return "sentinel 降级……";
    }

    @RequestMapping("/addOrder")
    @SentinelResource("addOrder")
    public String addOrder(){

        String ss = new String(new byte[1024*3]);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort+":addOrder success!";
    }

}
