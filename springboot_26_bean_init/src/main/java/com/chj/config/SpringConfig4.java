package com.chj.config;

import com.chj.bean.Dog;
import org.springframework.context.annotation.Import;

/**
 * Import
 * 导入一个普通的类
 * Spring会把它声明成一个bean 里面的bean也会被加载
 * 导入一个配置类
 * Spring会把它声明成一个bean  并且里面的bean也会被加载
 *
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */
@Import({Dog.class, DbConfig.class})
public class SpringConfig4 {

}
