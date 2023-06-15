package com.chj.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: UserProperties
 * @author: chj
 * @description:
 * @date: Created in  2023/6/15 20:07
 * @version: 1.0
 */

@Data
@ConfigurationProperties(prefix = "users")
public class UserProperties {
    private String name;
    private String age;
    private String sex;
}
