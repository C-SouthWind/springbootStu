package com.chj.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: Wolf
 * @author: chj
 * @description:
 * @date: Created in  2023/6/13 20:52
 * @version: 1.0
 * <p>
 * <p>
 * 在bean中实现了ApplicationContextAware这个类之后  就可以使用方法中的 applicationContext 这个对象了
 * 什么意思呢？
 * 实现ApplicationContextAware 可以在任何地方进行bean获取操作了
 */
@Component
public class Wolf implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void printBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
