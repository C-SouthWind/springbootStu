package com.chj.config;

import com.chj.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */

@ComponentScan({"com.chj.bean", "com.chj.config"})
public class SpringConfig3 {

    @Bean
    public DogFactoryBean dog() {
        return new DogFactoryBean();
    }
}
