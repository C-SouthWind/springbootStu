package com.chj.bean;

import com.chj.config.SpringConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: MyImportSelector
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 19:19
 * @version: 1.0
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        try {
            //如果加载了mouse 就加载cat
            Class<?> aClass = Class.forName("com.chj.bean.Mouse");
            if (aClass != null) {
                return new String[]{"com.chj.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            return new String[0];
        }
        return null;
    }
}
