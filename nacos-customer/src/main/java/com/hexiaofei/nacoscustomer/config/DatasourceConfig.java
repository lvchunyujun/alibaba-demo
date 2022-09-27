package com.hexiaofei.nacoscustomer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author lcyj
 * @date 2022-03-03 23:41
 * @since
 */
//@Configuration
public class DatasourceConfig {

//  @Bean
//  @Primary
//  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource primaryDataSource() {
      return DataSourceBuilder.create().build();
  }

}
