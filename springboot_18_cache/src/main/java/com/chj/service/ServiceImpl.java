package com.chj.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: ServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/4/26 20:13
 * @version: 1.0
 */
@Service
public class ServiceImpl implements IService {

    @Override
    @Cacheable(value = "cacheSpace", key = "#tel")
    public String code(String tel) {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean check(String tel, String code) {
        return false;
        //a6daed59-5534-47de-bfd7-66c59b48f3ac
    }
}
