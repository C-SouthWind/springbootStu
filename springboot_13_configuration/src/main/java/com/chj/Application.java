package com.chj;

import com.alibaba.druid.pool.DruidDataSource;
import com.chj.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: Springboot0103QuickstartApplication
 * @author: chj
 * @description:
 * @date: Created in  2023/2/14 20:19
 * @version: 1.0
 */
@SpringBootApplication
public class Application {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    public static void main(String[] args) {

        args = new String[]{"--server.port=89"};

        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        System.out.println(run.getBean(ServerConfig.class));
        System.out.println(run.getBean(DruidDataSource.class).getDriverClassName());
    }
}
