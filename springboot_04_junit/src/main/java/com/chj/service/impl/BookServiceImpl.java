package com.chj.service.impl;

import com.chj.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @projectName: springboot
 * @package: com.chj.service.impl
 * @className: BookServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/3/6 20:06
 * @version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("保存成功");
    }
}
