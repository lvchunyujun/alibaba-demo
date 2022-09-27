package com.hexiaofei.nacoscustomer;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableTransactionManagement                       // 事物管理
@MapperScan(basePackages = {"com.hexiaofei.nacoscustomer.dao"})
@ComponentScan(basePackages = {"com.hexiaofei.nacoscustomer"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosCustomerApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosCustomerApplication.class, args);

        Environment env = applicationContext.getEnvironment();
        String port = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        String userName = env.getProperty("userinfo.name");
        String age = env.getProperty("userinfo.age");
        String id = env.getProperty("userinfo.id");

        Map hashMap = new HashMap();
        hashMap.put("","");

        System.out.println("user name :" +userName);
        System.out.println("id:"+id);
        System.out.println("age: "+age);

        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info("\n----------------------------------------------------- -----\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}{}\n\t" +
                        "External: \thttp://{}:{}{}/\n\t" +
                        "doc:  \t\thttp://{}:{}{}/doc.html\n\t" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"), port, contextPath,
                hostAddress, port, contextPath,
                hostAddress, port, contextPath);
    }



}
