package com.chj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @projectName: springbootStu
 * @package: com.chj
 * @className: ServiceTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/12 19:47
 * @version: 1.0
 */
@SpringBootTest
@Transactional//为测试用例添加事务，springboot会对测试用例的事务提交操作进行回滚
@Rollback(value = false)//如果想在测试用例中提交事务可以设置true
public class ServiceTest {

    @Test
    void test(){

    }
}
