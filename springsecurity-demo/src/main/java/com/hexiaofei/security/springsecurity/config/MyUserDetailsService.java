package com.hexiaofei.security.springsecurity.config;

import com.hexiaofei.pubapi.entity.UserInfo;
import com.hexiaofei.security.springsecurity.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;

/**
 * 数据库的service
 * @author lcyj
 * @date 2022-02-27 12:37
 * @since
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IUserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;

        UserInfo userInfo = userInfoService.getUserInfo();

        if(userInfo == null){

            throw new CredentialsExpiredException("密码过期！");
        }else{
            throw new LockedException("用户锁定！");
        }
    }
}
