package com.chj.app;

import com.chj.bean.Dog;
import com.chj.config.SpringConfig3;
import com.chj.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @projectName: springbootStu
 * @package: com.chj.app
 * @className: App1
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:12
 * @version: 1.0
 */
public class App4 {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(ctx.getBean(Dog.class));
    }
}





















