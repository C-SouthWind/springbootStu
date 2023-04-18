package com.chj;

import com.chj.config.MsgBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @projectName: springbootStu
 * @package: com.chj
 * @className: ConfigTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/3 21:06
 * @version: 1.0
 */
@SpringBootTest
@Import(MsgBean.class)
public class ConfigTest {

    @Autowired
    private String msg;

    @Test
    public void aa(){
        System.out.println(msg);
    }
}
