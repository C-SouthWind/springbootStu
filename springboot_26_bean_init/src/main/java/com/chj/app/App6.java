package com.chj.app;

import com.chj.bean.Cat;
import com.chj.bean.Mouse;
import com.chj.config.SpringConfig5;
import com.chj.config.SpringConfig6;
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
public class App6 {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig6.class);

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}





















