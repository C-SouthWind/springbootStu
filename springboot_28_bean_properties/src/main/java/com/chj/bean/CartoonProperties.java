package com.chj.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: CartoonProperties
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 20:22
 * @version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "cartoon")
public class CartoonProperties {
    private Cat cat;
    private Mouse mouse;
}
