package com.chj.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @CreateCache(name = "jetCache", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    private Cache<String, String> cache;

    @CreateCache(area = "sms", name = "jetCache", expire = 3600, timeUnit = TimeUnit.SECONDS)
    private Cache<String, String> cache1;


    @CreateCache(name = "jetCache", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> cache2;

    @Override
    public String code(String tel) {
        String code = UUID.randomUUID().toString();
        cache.put(tel, code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        String s = cache.get(tel);
        return false;
        //a6daed59-5534-47de-bfd7-66c59b48f3ac
    }
}
