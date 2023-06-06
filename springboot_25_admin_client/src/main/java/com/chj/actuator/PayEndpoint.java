package com.chj.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.actuator
 * @className: PayEndpoin
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 19:46
 * @version: 1.0
 */
@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndpoint {

    @ReadOperation
    public Object getPay() {
        System.out.println("===================================");
        return "xxxxxx";
    }

}
