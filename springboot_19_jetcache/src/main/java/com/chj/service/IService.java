package com.chj.service;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: Service
 * @author: chj
 * @description:
 * @date: Created in  2023/4/26 20:12
 * @version: 1.0
 */
public interface IService {

    String code(String tel);

    boolean check(String tel, String code);
}
