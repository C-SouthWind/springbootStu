package com.chj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springbootStu
 * @package: com.chj
 * @className: PropertiesAndArgsTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/3 19:45
 * @version: 1.0
 */
//properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"server.port=89"})
@SpringBootTest(args = {"--server.port=50"})
public class PropertiesAndArgsTest {


    @Value("${server.port}")
    private String port;

    @Test
    void testProperties() {
        System.out.println(port);
    }

}
