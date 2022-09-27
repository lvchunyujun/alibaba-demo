package com.hexiaofei.security.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lcyj
 * @date 2022-02-27 15:19
 * @since
 */
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // step1: 页面表提交上来的用户密码(密码为编码后的密文)
        String username = authentication.getPrincipal().toString();
        String rawPassword = authentication.getCredentials().toString();

        // step2: 根据用户名加载UserDetails()
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // step3: 密码验证通过，缓存登录信息（JWT token）
        if(new BCryptPasswordEncoder().matches(rawPassword,userDetails.getPassword())){

            System.out.println("登录成功！");

            // 缓存登录信息（JWT token）
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
            return usernamePasswordAuthenticationToken;
        }else {

            throw new BadCredentialsException("用户名密码错误！");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
