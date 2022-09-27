package com.hexiaofei.security.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Ctrl + Enter : 重写方法
 * @author lcyj
 * @date 2022-02-26 09:27
 * @since
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_HTML = "/login.html";
    private static final String LOGIN = "/login";
    private static final String LOGIN_SUCCESS = "/welcome.html";
    private static final String LOGIN_FAILURE = "/login.html";

    @Override
    public void configure(WebSecurity web) throws Exception {
        //不经过拦截器
        web.ignoring()
           .antMatchers("/img/**","/css/**","/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println(new BCryptPasswordEncoder().encode("000000"));
        System.out.println(new BCryptPasswordEncoder().encode("000000"));

        http
                // 拦截所有请求
            .authorizeRequests()
                // 不拦截静态资源,不建议
//            .antMatchers("/img/**","/css/**","/js/**").permitAll()
            .anyRequest().authenticated()
                // 登录页面
            .and().formLogin().loginPage(LOGIN_HTML)
                // 配置用户名、密码
                // 登录处理action
            .loginProcessingUrl(LOGIN).permitAll()
                // 只是将页面定向到url,不会将上下文信息带过去
//            .failureUrl("/login.html?error")
                // 登录成功跳转页面
//            .defaultSuccessUrl(WEBCOME).permitAll()

            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                    System.out.println("登录成功！");

                    request.getRequestDispatcher(LOGIN_SUCCESS).forward(request,response);
                }
            })
                // 登录用户名/密码字段名称
            .usernameParameter("user").passwordParameter("password")
            .failureHandler(new AuthenticationFailureHandler() {
                @Override
                public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                    exception.printStackTrace();

                    if (exception instanceof BadCredentialsException){
                        System.out.println("用户密码错误！");
                    }
                    request.getRequestDispatcher(LOGIN_FAILURE).forward(request,response);
                }
            })
                // 拦截CSRF攻击
            .and().csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }

    /**
     * 定义UserManagerDetails: 方法1-MEMORY
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("000000")).roles("admin")
//                .and()
//                .withUser("lisi")
//                .password(new BCryptPasswordEncoder().encode("000000")).roles("user")
//                .and()
//                .withUser("wangwu")
//                // 必须指定roles
//                .password(new BCryptPasswordEncoder().encode("000000")).roles("user");
//
//    }
    /**
     * 定义UserManagerDetails: 方法2
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        ArrayList<SimpleGrantedAuthority> sList = new ArrayList<>();
        sList.add(new SimpleGrantedAuthority("admin"));
        sList.add(new SimpleGrantedAuthority("user"));

        User user = new User("aaa", new BCryptPasswordEncoder().encode("000000"), sList);
        inMemoryUserDetailsManager.createUser(user);
        inMemoryUserDetailsManager.createUser(
                User.withUsername("ooxx")
                    .password(new BCryptPasswordEncoder().encode("000000"))
                    .roles("user").build()
        );

        return inMemoryUserDetailsManager;
    }

    /**
     * 定义UserManagerDetails: 方法3-JDBC
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new MyUserDetailsService());
//
//    }

    /**
     * 定义UserManagerDetails: 方法4-自定义认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProviderImpl());

    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
