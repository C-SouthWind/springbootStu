package com.chj.test;

import com.chj.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springboot
 * @package: com.chj.test
 * @className: MapperTest
 * @author: chj
 * @description:
 * @date: Created in  2023/3/8 20:05
 * @version: 1.0
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(userMapper.getById(1));
    }
}
