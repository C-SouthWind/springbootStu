package com.chj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@MapperScan("com.chj.mapper")
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
