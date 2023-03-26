package com.chj.controller;


import com.chj.ann.Aa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class NewBookController {

    //private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("{aa}")
    @Aa
    public String getById(@PathVariable String aa) {
        log.info("info");
        log.error("error");
        log.warn("warn");
        log.debug("debug");
        String str = "springBoot is running...3";
        System.out.println(str);
        return str;
    }
}
