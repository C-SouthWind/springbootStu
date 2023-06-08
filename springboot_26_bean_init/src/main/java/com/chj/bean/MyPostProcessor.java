package com.chj.bean;

import com.chj.service.impl.BookServiceImpl2;
import com.chj.service.impl.BookServiceImpl3;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * bean注册完之后  进行的操作
 * 最终的修改  当bean加载完之后对bean进行操作
 *
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: MyPosrProcessor
 * @author: chj
 * @description:
 * @date: Created in  2023/6/8 20:12
 * @version: 1.0
 */
public class MyPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //用法与MyRegistrar一致
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BookServiceImpl3.class).getBeanDefinition();
        registry.registerBeanDefinition("bookService", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
