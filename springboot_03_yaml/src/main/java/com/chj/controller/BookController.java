package com.chj.controller;


import com.chj.Service.ReadPropertiesService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private ReadPropertiesService readPropertiesService;

    @GetMapping
    public String getById() {
        String str = "springBoot is running...";
        System.out.println(str);
        return readPropertiesService.Read();
    }
    @GetMapping("/a")
    public String ReadEnvironment() {
        String str = "springBoot is running...";
        System.out.println(str);
        return readPropertiesService.ReadEnvironment();
    }
    @GetMapping("/data")
    public String ReadDataSource() {
        String str = "springBoot is running...";
        System.out.println(str);
        return readPropertiesService.ReadDataSource();
    }
}
