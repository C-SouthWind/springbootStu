package com.chj.configuration;

import com.chj.properties.IpProperties;
import com.chj.sevice.IpCountService;
import com.chj.sevice.impl.IpCountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @projectName: springbootStu
 * @package: com.chj.autoconfig
 * @className: IpAutoCondiguration
 * @author: chj
 * @description:
 * @date: Created in  2023/6/15 21:18
 * @version: 1.0
 */
@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import(IpProperties.class)
public class IpAutoConfiguration {


    @Bean
    public IpCountService ipCountService() {
        return new IpCountServiceImpl();
    }
}
