package com.hexiaofei.dubbo.provider.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lcyj
 * @date 2022-04-16 11:15
 * @since
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.hexiaofei.dubbo.provider.service.impl")
@PropertySource(value = "classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
}
