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
public class UserLoginController {

    @Value("${userinfo.name}")
    private String name;

    @Value("${userinfo.age}")
    private String age;

    @Value("${userinfo.id}")
    private String id;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value="getLoginConfig.json")
    public String getLoginConfig(String username,String password){

        log.info("getLoginConfig.json");
        return "systemName";
    }

    @RequestMapping(value="jwt/login.json")
    public UserInfo login(String username,String password){

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setUserid("10001");
        userInfo.setServers("SERVER_ADMIN");
        log.info(userInfo.toString());
        return userInfo;
    }


}
