package com.chj.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @projectName: springbootStu
 * @package: com.chj.bean
 * @className: CoodTomAdnMouse
 * @author: chj
 * @description:
 * @date: Created in  2023/6/12 20:05
 * @version: 1.0
 */
@Data
@EnableConfigurationProperties(CartoonProperties.class)
public class CartoonCatAdnMouse {
    private Cat cat;
    private Mouse mouse;
    private CartoonProperties cartoonProperties;

    public CartoonCatAdnMouse(CartoonProperties cartoonProperties) {
        this.cartoonProperties = cartoonProperties;
        cat = new Cat();
        cat.setAge(cartoonProperties.getCat() != null && cartoonProperties.getCat().getAge() != null ? cartoonProperties.getCat().getAge() : 3);
        cat.setName(cartoonProperties.getCat() != null && StringUtils.hasText(cartoonProperties.getCat().getName()) ? cartoonProperties.getCat().getName() : "tom");

        mouse = new Mouse();
        mouse.setAge(cartoonProperties.getCat() != null && cartoonProperties.getMouse().getAge() != null ? cartoonProperties.getMouse().getAge() : 4);
        mouse.setName(StringUtils.hasText(cartoonProperties.getMouse().getName()) ? cartoonProperties.getMouse().getName() : "jerry");
    }

    public void play() {
        System.out.println(cat.getAge() + "岁的" + cat.getName() + "和" + mouse.getAge() + "岁的" + mouse.getName() + "打起来了");
    }

}
