package com.chj.tests;

import com.chj.mapper.ImportUserMapper;
import com.chj.model.Appuser;
import com.chj.service.ImportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: springbootStu
 * @package: com.chj.tests
 * @className: ImportTest
 * @author: chj
 * @description:
 * @date: Created in  2023/3/23 20:39
 * @version: 1.0
 */
@SpringBootTest
public class ImportTest {

    @Autowired
    private ImportUserMapper userMapper;

    @Autowired
    private ImportService importService;

    @Test
    public void aa(){
        importService.excelImport();
    }
    @Test
    public void a2a(){
        Appuser user = new Appuser();
        user.setId(Long.valueOf("1"));
        user.setName("1");
        user.setEmail("1");
        user.setPhone("1");
        user.setGender(Integer.valueOf("1"));
        user.setPassword("1");
        user.setAge(Integer.valueOf("1"));
        this.userMapper.insert(user);

        System.out.println(userMapper.selectList(null));

    }
}
