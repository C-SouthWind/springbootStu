package com.chj.test;


import com.chj.service.IService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springboot
 * @package: com.chj.test
 * @className: MybatisPlusTest
 * @author: chj
 * @description:
 * @date: Created in  2023/3/8 21:12
 * @version: 1.0
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private IService service;

    @Test
    public void test() {
        System.out.println(service.code("123456"));
    }
}
