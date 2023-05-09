package com.chj.service;


import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private CacheChannel channel;

    @Override
    public String code(String tel) {
        String code = UUID.randomUUID().toString();
        channel.set("sms", tel, code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        channel.get("sms", tel).asString();
        return false;
        //a6daed59-5534-47de-bfd7-66c59b48f3ac
    }
}
