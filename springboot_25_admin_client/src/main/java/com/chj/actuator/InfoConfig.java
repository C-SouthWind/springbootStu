package com.chj.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.actuator
 * @className: InfoConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/5/22 20:20
 * @version: 1.0
 */
@Configuration
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("计算", 2 + 1);
    }
}
