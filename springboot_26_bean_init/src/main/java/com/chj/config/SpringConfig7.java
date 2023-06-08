package com.chj.config;

import com.chj.bean.MyImportSelector;
import com.chj.bean.MyRegistrar;
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
@Import(MyRegistrar.class)
public class SpringConfig7 {

}
