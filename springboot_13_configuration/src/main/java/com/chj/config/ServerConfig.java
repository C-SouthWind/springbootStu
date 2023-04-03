package com.chj.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: ServletConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/3/28 20:45
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "servers")
//2、开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    //3、设置具体规则
    @Max(value = 8888, message = "最大值不能超过8888")
    private int port;
    private long timeout;

    @DurationUnit(ChronoUnit.DAYS)
    private Duration serverTimeOut;

    @DataSizeUnit(DataUnit.BYTES)
    private DataSize dataSize;
}
