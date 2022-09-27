package com.hexiaofei.security.springsecurity.service.impl;

import com.hexiaofei.pubapi.entity.UserInfo;
import com.hexiaofei.security.springsecurity.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author lcyj
 * @date 2022-02-27 12:47
 * @since
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Override
    public UserInfo getUserInfo() {
        return new UserInfo();
    }
}
