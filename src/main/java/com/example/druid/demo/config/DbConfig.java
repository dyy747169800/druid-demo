package com.example.druid.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.druid.demo.datasource.DataSourceConstant;
import com.example.druid.demo.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 段杨宇
 * @create 2019-04-15 18:59
 **/
@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource dataSourceMaster(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource dataSourceSlave(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource dataSourceMaster, DataSource dataSourceSlave) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceConstant.MASTER, dataSourceMaster);
        targetDataSources.put(DataSourceConstant.SLAVE,dataSourceSlave);
        return new DynamicDataSource(dataSourceMaster, targetDataSources);
    }


}
