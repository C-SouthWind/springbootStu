package com.chj.test;

import com.chj.mapper.UserMPMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @projectName: springbootStu
 * @package: com.chj.test
 * @className: MapperTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/12 20:09
 * @version: 1.0
 */
@SpringBootTest
public class MapperTest {


    @Resource
    private UserMPMapper userMPMapper;

    @Test
    void test(){
        System.out.println(userMPMapper.selectList(null));
    }
}
