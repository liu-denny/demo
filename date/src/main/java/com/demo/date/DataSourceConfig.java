package com.demo.date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yudong
 * @create 2019-11-21 12:18
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "DataSources.master")
    // application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "DataSources.dev")
    // application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    public DataSource dataSourceDev() {
        return DataSourceBuilder.create().build();
    }
}
