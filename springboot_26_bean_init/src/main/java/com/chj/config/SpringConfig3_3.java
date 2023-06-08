package com.chj.config;

import com.chj.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration(proxyBeanMethods = true)
 * CGLIB代理 com.chj.config.SpringConfig33$$EnhancerBySpringCGLIB$$b206055c@6580cfdd
 * 创建对象是单例的
 * com.chj.bean.Cat@6dc17b83
 * com.chj.bean.Cat@6dc17b83
 * com.chj.bean.Cat@6dc17b83
 * @Configuration(proxyBeanMethods = false)
 * com.chj.config.SpringConfig33@49e202ad
 * 创建对象不是单例的
 * com.chj.bean.Cat@6b53e23f
 * com.chj.bean.Cat@64d2d351
 * com.chj.bean.Cat@1b68b9a4
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfig3_3 {

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
