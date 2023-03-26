package com.chj.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: springbootStu
 * @package: com.chj.controller.ann
 * @className: aa
 * @author: chj
 * @description:
 * @date: Created in  2023/3/26 21:09
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Aa {
}
