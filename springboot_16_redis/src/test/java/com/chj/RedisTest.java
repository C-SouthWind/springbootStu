package com.chj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @projectName: springbootStu
 * @package: com.chj
 * @className: RedisTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/18 20:13
 * @version: 1.0
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void setGet() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("aa", "11");
        System.out.println(valueOperations.get("aa"));
    }

    @Test
    void hashSetGet() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info", "a", "1");
        System.out.println(hashOperations.get("info", "a"));
    }
}
