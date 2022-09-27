package com.hexiaofei.security.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcyj
 * @date 2022-02-25 23:44
 * @since
 */

@Controller
public class LoginController {

    @RequestMapping("/login.html")
    public String hello(){

        return "login";
    }

    @RequestMapping("/welcome.html")
    public String loginSuccess(){
        return "welcome";
    }
}
