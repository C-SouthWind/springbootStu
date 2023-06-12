package com.chj;

import com.chj.bean.CartoonCatAdnMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: Springboot0103QuickstartApplication
 * @author: chj
 * @description:
 * @date: Created in  2023/2/14 20:19
 * @version: 1.0
 */
@SpringBootApplication
@Import(CartoonCatAdnMouse.class)
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        CartoonCatAdnMouse bean = ctx.getBean(CartoonCatAdnMouse.class);
        bean.play();
    }
}
