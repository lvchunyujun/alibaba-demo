package com.hexiaofei.nacoscustomer.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hexiaofei.nacoscustomer.service.IUserinfoService;
import com.hexiaofei.nacoscustomer.service.feign.OrderFeignClient;
import com.hexiaofei.pubapi.entity.UserInfo;
import com.hexiaofei.pubapi.web.RespEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lcyj
 * @date 2021-11-20 13:13
 * @since
 */
@Slf4j
@RestController
public class UserinfoController {

    @Value("${userinfo.name}")
    private String name;

    @Value("${userinfo.age}")
    private String age;

    @Value("${userinfo.id}")
    private String id;

    @Value("${server.port}")
    private String port;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping(value="addOrder")
    @SentinelResource("addOrder")
    public String getUserInfo(){

        return orderFeignClient.addOrder();
    }

    @RequestMapping("/addBatchUserinfo/{count}")
    public RespEntity addBatchUserinfo(@PathVariable("count") int count){
        RespEntity<List<UserInfo>> listRespEntity = new RespEntity<List<UserInfo>>();

        List<UserInfo> userInfos = new ArrayList<>();

        List<UserInfo> listResp = new ArrayList();
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < count ; i++ ){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid("userid:"+i);
            userInfo.setUsername("zhangsan"+i);
            if(i>5000)
            userInfo.setUsername(null);
            userInfo.setServers("UC");
            userInfo.setIdNo("1000001");
            userInfo.setAge(20);
            userInfo.setAddr("addr:"+i);
            userInfos.add(userInfo);
        }
        listResp = userinfoService.addBatchObject(userInfos);
        log.info("耗时： "+(System.currentTimeMillis()-start));
        listRespEntity.setCode("0000");
        listRespEntity.setMsg("success");
        listRespEntity.setDate(listResp);
        return listRespEntity;
    }

    @RequestMapping("/addUserinfo")
    public RespEntity addUserinfo(){
        RespEntity<UserInfo> listRespEntity = new RespEntity<UserInfo>();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("userid:1001");
        userInfo.setUsername("zhangsan");
        userInfo.setServers("UC");
        userInfo.setIdNo("1000001");
        userInfo.setAge(20);

        int userid = userinfoService.addObject(userInfo);
        listRespEntity.setCode("0000");
        listRespEntity.setMsg("success");
        listRespEntity.setDate(userInfo);
        return listRespEntity;
    }



}
