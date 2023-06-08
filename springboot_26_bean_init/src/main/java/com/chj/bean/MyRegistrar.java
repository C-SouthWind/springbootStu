package com.chj.bean;

import com.chj.app.App6;
import com.chj.service.impl.BookServiceImpl2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 开放了元数据和bean的操作
 * 用bean对象加载
 * <p>
 * 通过BeanDefinition的注册实名bean，实现对容器中bean的裁定，例如对现有bean的覆盖，进而达成不修改源代码的情况下更换实现效果
 *
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: MyRegistrar
 * @author: chj
 * @description:
 * @date: Created in  2023/6/8 19:59
 * @version: 1.0
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {
//    App7
//    @Override
//    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
//        //importingClassMetadata  操作与MyImportSelector 中一致
//        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class).getBeanDefinition();
//        registry.registerBeanDefinition("yellow",beanDefinition);
//    }

    //App8
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //importingClassMetadata  操作与MyImportSelector 中一致
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BookServiceImpl2.class).getBeanDefinition();
        registry.registerBeanDefinition("bookService", beanDefinition);
    }
}
