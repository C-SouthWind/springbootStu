package com.chj;

import com.chj.configuration.UserAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: Springboot0103QuickstartApplication
 * @author: chj
 * @description:
 * @date: Created in  2023/2/14 20:19
 * @version: 1.0
 */
//@SpringBootApplication(excludeName = "com.chj.configuration.UserAutoConfiguration")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //application.yml 中排除了自动配置的dean: UserAutoConfiguration
        UserAutoConfiguration userAutoConfiguration = run.getBean(UserAutoConfiguration.class);
        userAutoConfiguration.play();
    }
}
