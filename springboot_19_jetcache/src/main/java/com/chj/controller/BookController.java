package com.chj.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springboot
 * @package: com.chj.controller
 * @className: BookController
 * @author: chj
 * @description: 书控制类
 * @date: Created in  2023/2/9 18:54
 * @version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        String str = "springBoot is running...3";
        System.out.println(str);
        return str;
    }


}
