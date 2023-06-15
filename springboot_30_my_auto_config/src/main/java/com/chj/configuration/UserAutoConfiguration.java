package com.chj.configuration;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: UserAutoConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/6/15 20:09
 * @version: 1.0
 */
@Data
//@ConditionalOnClass(name = "com.chj.aa")
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfiguration {

    @Autowired
    private UserProperties userProperties;

    public void play() {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.hasText(userProperties.getName())) {
            userProperties.setName("chj");
        }
        if (!StringUtils.hasText(userProperties.getAge())) {
            userProperties.setAge("24");
        }
        if (!StringUtils.hasText(userProperties.getSex())) {
            userProperties.setSex("男");
        }
        System.out.println(userProperties.toString());
    }

}
