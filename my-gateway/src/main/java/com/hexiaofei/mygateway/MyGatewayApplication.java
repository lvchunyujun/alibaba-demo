package com.hexiaofei.mygateway;

import com.hexiaofei.mygateway.filter.JWTFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class MyGatewayApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(MyGatewayApplication.class, args);
		String userName = applicationContext.getEnvironment().getProperty("user.name");
		String userAge = applicationContext.getEnvironment().getProperty("user.age");
		System.err.println("user name :" + userName + "; age: " + userAge);
		Environment env = applicationContext.getEnvironment();
		String port = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		log.info("\n----------------------------------------------------- -----\n\tApplication '{}' is running! Access URLs:\n\tLocal: \t\thttp://localhost:{}{}\n\tExternal: \thttp://{}:{}{}/\n\tdoc:  \t\thttp://{}:{}{}/doc.html\n\t----------------------------------------------------------", new Object[]{env.getProperty("spring.application.name"), port, contextPath, hostAddress, port, contextPath, hostAddress, port, contextPath});

	}



}
