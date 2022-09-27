package com.hexiaofei.security.springsecurity.web.filter;

import com.hexiaofei.security.springsecurity.util.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lcyj
 * @date 2022-03-01 10:59
 * @since
 */
@WebFilter(urlPatterns = "/login")
@Component
public class JWTFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init:");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter:");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String jwt_token = request.getParameter("jwt_token");

        if(jwt_token != null && jwt_token.length() > 0){
            String tokenStr = JWTUtils.parseToken(jwt_token);
            System.out.println(tokenStr);
        }else {
            System.out.println("用户未登录！");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy:");
    }
}
