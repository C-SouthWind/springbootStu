package com.chj.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: springboot
 * @package: com.chj.config
 * @className: Result
 * @author: chj
 * @description:
 * @date: Created in  2023/3/15 21:19
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private String code;
    private String massage;
    private Object T;
}
