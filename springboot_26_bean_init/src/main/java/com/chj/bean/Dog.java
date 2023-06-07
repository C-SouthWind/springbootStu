package com.chj.bean;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: Dog
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:05
 * @version: 1.0
 */
public class Dog {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
