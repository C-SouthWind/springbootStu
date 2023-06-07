package com.chj.app;

import com.chj.bean.Cat;
import com.chj.bean.Dog;
import com.chj.bean.Mouse;
import com.chj.config.SpringConfig4;
import com.chj.config.SpringConfig5;
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
public class App5 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig5.class);
        //上下文容器对象已经初始化完毕后，手工加载bean  注册bean的时候 同名的bean被覆盖掉
        ctx.registerBean("tom", Cat.class);
        ctx.registerBean("tom", Cat.class);

        ctx.register(Mouse.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(ctx.getBean("tom"));
    }
}





















