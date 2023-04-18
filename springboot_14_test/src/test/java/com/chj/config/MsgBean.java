package com.chj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: MsgBean
 * @author: chj
 * @description:
 * @date: Created in  2023/4/3 21:05
 * @version: 1.0
 */
@Configuration
public class MsgBean {

    @Bean
    public String msg(){
        return "msg bean";
    }
}
