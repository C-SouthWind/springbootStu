package com.chj.config;

import com.chj.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.chj")
@Import(MyImportSelector.class)
public class SpringConfig6 {

}
