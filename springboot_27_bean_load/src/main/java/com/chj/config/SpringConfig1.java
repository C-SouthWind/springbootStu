package com.chj.config;

import com.chj.bean.Cat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 19:17
 * @version: 1.0
 */
@ComponentScan("com.chj.bean")
public class SpringConfig1 {


}
