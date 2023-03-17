package com.chj.config;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @projectName: springboot
 * @package: com.chj.config
 * @className: ControllerAdvice
 * @author: chj
 * @description: 统一异常处理
 * @date: Created in  2023/3/15 21:15
 * @version: 1.0
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result("500","系统异常",null);
    }

}
