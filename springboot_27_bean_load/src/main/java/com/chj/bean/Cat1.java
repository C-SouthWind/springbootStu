package com.chj.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: Cat
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 19:13
 * @version: 1.0
 */
@Component("tom")
@ConditionalOnBean(name = "jerry")
@ConditionalOnNotWebApplication
public class Cat1 {
}
