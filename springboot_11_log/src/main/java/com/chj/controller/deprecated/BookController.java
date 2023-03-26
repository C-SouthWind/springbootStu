package com.chj.controller.deprecated;


import com.chj.controller.deprecated.BaseClass;
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
@RequestMapping("/book")
public class BookController extends BaseClass {

    //private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById() {
        log.info("info");
        log.error("error");
        log.warn("warn");
        log.debug("debug");
        String str = "springBoot is running...3";
        System.out.println(str);
        return str;
    }
}
