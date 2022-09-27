package com.hexiaofei.nacoscustomer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcyj
 * @date 2021-12-02 17:45
 * @since
 */
@RequestMapping("/system")
@RestController
public class SystemParametersController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/port")
    public String getServerPort(){
        return serverPort;
    }
}
