package com.chj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: DbConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:31
 * @version: 1.0
 */
//@Component
@Configuration
public class DbConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }
}
