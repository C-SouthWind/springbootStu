package com.chj.ann;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.platform.commons.util.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.controller.ann
 * @className: aaa
 * @author: chj
 * @description:
 * @date: Created in  2023/3/26 21:10
 * @version: 1.0
 */

@Aspect
@Order(1)
@Component
public class Aaa {

    @Pointcut(value = "@annotation(com.chj.ann.Aa)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint join) {
        System.out.println(join.getArgs());
        System.out.println("在注解之前");
    }

    @After("pointcut()")
    public void after(JoinPoint join) {
        System.out.println(join);
        System.out.println("在注解之后");
    }
}
