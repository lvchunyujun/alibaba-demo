package com.hexiaofei.dubbo.customer.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lcyj
 * @date 2022-04-16 11:19
 * @since
 */
@Configuration
@PropertySource("classpath:/dubbo-consumer.properties")
@EnableDubbo(scanBasePackages = "com.hexiaofei.dubbo.customer")
public class ConsumerConfiguration {
}
