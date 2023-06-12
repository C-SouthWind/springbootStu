package com.chj.config;

import com.chj.bean.Cat;
import com.chj.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 19:17
 * @version: 1.0
 */
//@Import(MyImportSelector.class)
public class SpringConfig {

    //有Module这个类就加载Cat
    @Bean
    @ConditionalOnClass(Module.class)
    public Cat tom() {
        return new Cat();
    }

    //没有Wolf这个类就加载Cat
    @Bean
    @ConditionalOnMissingClass("com.chj.bean.Wolf")
    public Cat tom1() {
        return new Cat();
    }


    /**
     * @ConditionalOnBean(name = "com.chj.bean.Mouse")  ： 有Mouse这个bean就加载Cat
     * @ConditionalOnBean(name = "jerry")   ：  bean名称叫jerry的加载了就加载Cat
     * @ConditionalOnMissingClass("com.chj.bean.Dog") ：  没有Dog这个类就加载
     * @ConditionalOnNotWebApplication ：   不是web项目才加载
     */
    @Bean
    //@ConditionalOnBean(name = "com.chj.bean.Mouse")
    @ConditionalOnBean(name = "jerry")
    @ConditionalOnMissingClass("com.chj.bean.Dog")
    @ConditionalOnNotWebApplication
    public Cat tom2() {
        return new Cat();
    }
}
