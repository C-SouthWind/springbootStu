package com.chj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: MybatisPlusConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/3/24 22:40
 * @version: 1.0
 */
@Component
public class MybatisPlusConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("transactionManager")
    public TransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
