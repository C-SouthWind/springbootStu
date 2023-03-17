package com.chj.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chj.mapper.UserMPMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springboot
 * @package: com.chj.mybatisplus
 * @className: MPTest
 * @author: chj
 * @description:
 * @date: Created in  2023/3/9 20:18
 * @version: 1.0
 */
@SpringBootTest
public class MPTest {

    @Autowired
    private UserMPMapper userMap;

    @Test
    public void aa(){
        System.out.println(userMap.selectById(1));
    }

}
