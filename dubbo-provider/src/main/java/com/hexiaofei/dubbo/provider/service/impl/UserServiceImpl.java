package com.hexiaofei.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.hexiaofei.pubapi.entity.PageVo;
import com.hexiaofei.pubapi.entity.UserInfo;
import com.hexiaofei.pubapi.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/**
 * @author lcyj
 * @date 2022-04-15 15:38
 * @since
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Value("${provider.service.name}")
    private String serviceName;


    @Override
    public int addObject(UserInfo userInfo) {
        log.info(userInfo.toString());

        RpcContext rpcContext = RpcContext.getContext();
        String rpcStr = String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName()
        );
        log.debug(rpcStr);
        return 0;
    }

    @Override
    public List<UserInfo> addBatchObject(List<UserInfo> t) {
        return null;
    }


    @Override
    public int deleteObjectById(Integer id) {
        return 0;
    }

    @Override
    public int updateObjectById(Integer id) {
        return 0;
    }

    @Override
    public com.hexiaofei.pubapi.entity.UserInfo getObjectById(Integer id) {
        return null;
    }


    @Override
    public PageVo getListByPageVo(PageVo pageVo, Map paraMap) {
        return null;
    }

}
