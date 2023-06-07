package com.chj.bean;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: DogFactoryBean
 * @author: chj
 * @description:
 * @date: Created in  2023/6/7 19:24
 * @version: 1.0
 */
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        Dog dog = new Dog();
        dog.setName("aa");
        return dog;
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
