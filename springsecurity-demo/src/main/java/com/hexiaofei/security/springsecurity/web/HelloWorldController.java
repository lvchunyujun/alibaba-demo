package com.hexiaofei.security.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcyj
 * @date 2022-02-25 23:44
 * @since
 */

@RestController
public class HelloWorldController {


    @RequestMapping("/hello")
    public String hello(){

        return "Hello World!";
    }
}
