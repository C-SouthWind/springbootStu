package com.chj.test;

import com.chj.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: TestOne
 * @author: chj
 * @description: 第一个测试
 * @date: Created in  2023/3/6 19:56
 * @version: 1.0
 */
@SpringBootTest
public class TestOne {

    @Autowired
    private BookService bookService;


    @Test
    void test(){
        System.out.println("test...");
    }

    @Test
    void test2(){
        bookService.save();
    }
}
