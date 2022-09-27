package com.hexiaofei.nacoscustomer.web;

import com.hexiaofei.pubapi.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcyj
 * @date 2021-11-20 13:13
 * @since
 */
@Slf4j
@RestController
@RefreshScope
public class HelloWorldController {

    @Value("${userinfo.name}")
    private String name;

    @Value("${userinfo.age}")
    private String age;

    @Value("${userinfo.id}")
    private String id;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "getFlag")
    public String getFlag(Integer id){
        long tid = Thread.currentThread().getId();
        return "[port:"+port+"]"+tid+":"+name+":"+age+":"+id;
    }

    @RequestMapping(value="getUserinfo")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张三");
        userInfo.setAge(20);
        userInfo.setIdNo("2323232323");
        log.info("[port:{}]",port);
        return userInfo;
    }



}
