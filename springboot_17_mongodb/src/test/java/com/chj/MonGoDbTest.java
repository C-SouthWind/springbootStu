package com.chj;

import com.chj.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @projectName: springbootStu
 * @package: com.chj
 * @className: MongoDbTest
 * @author: chj
 * @description:
 * @date: Created in  2023/4/20 21:16
 * @version: 1.0
 */
@SpringBootTest
public class MonGoDbTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    void save() {
        User user = new User();
        user.setName("aa");
        mongoTemplate.save(user);
    }

    @Test
    void find() {
        mongoTemplate.findAll(User.class);
    }
}







































