package com.chj.configuration;

import com.chj.sevice.IpCountService;
import com.chj.sevice.impl.IpCountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.autoconfig
 * @className: IpAutoCondiguration
 * @author: chj
 * @description:
 * @date: Created in  2023/6/15 21:18
 * @version: 1.0
 */
public class IpAutoConfiguration {


    @Bean
    public IpCountService ipCountService() {
        return new IpCountServiceImpl();
    }
}
