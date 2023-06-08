package com.chj.config;

import com.chj.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 导入applicationContext1.xml中的所有配置
 *
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */

@ImportResource("applicationContext1.xml")
public class SpringConfig3_2 {

}
