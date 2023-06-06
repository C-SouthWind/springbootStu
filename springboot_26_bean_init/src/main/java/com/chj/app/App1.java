package com.chj.app;

import com.chj.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: springbootStu
 * @package: com.chj.app
 * @className: App1
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:12
 * @version: 1.0
 */
public class App1 {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
//        Object cat = ctx.getBean("cat");
//        System.out.println(cat);
//        Dog dog = ctx.getBean(Dog.class);
//        System.out.println(dog);

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
