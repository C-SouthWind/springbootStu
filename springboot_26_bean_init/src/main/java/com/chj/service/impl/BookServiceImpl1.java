package com.chj.service.impl;

import com.chj.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.impl
 * @className: BookServiceImpl1
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:07
 * @version: 1.0
 */
@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("book service 1..");
    }
}
