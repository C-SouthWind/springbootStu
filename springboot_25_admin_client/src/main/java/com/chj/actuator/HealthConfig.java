package com.chj.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: springbootStu
 * @package: com.chj.actuator
 * @className: HealthConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 19:33
 * @version: 1.0
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("runTime", System.currentTimeMillis());
        Map infoMap = new HashMap();
        infoMap.put("计算", 2 + 1);
        builder.withDetails(infoMap);
        builder.status(Status.UP);
    }
}
