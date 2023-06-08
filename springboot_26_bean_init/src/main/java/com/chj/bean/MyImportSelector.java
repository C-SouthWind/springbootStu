package com.chj.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 自动装配底层
 * 多数在源码中用到  用类名加载
 *
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: MyImportSelector
 * @author: chj
 * @description:
 * @date: Created in  2023/6/8 19:37
 * @version: 1.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //===========com.chj.config.SpringConfig6
        System.out.println("====== 类名称 =====" + importingClassMetadata.getClassName());
        //SpringConfig6 上面有没有Configuration注解
        System.out.println("====== 类上注解 =====" + importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration"));
        //SpringConfig6 上面配置注解中的属性
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes("org.springframework.context.annotation.ComponentScan");
        System.out.println("====== 类上注解中的属性 =====" + annotationAttributes);


        //SpringConfig6 上面有Configuration注解
        if (importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration")) {
            return new String[]{"com.chj.bean.Dog"};
        } else {
            return new String[]{"com.chj.bean.Cat"};
        }
    }
}
