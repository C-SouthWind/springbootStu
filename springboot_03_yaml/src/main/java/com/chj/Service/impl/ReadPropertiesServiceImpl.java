package com.chj.Service.impl;

import com.chj.Service.ReadPropertiesService;
import com.chj.entriy.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @projectName: springboot
 * @package: com.chj.Service.impl
 * @className: ReadPropertiesServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/3/2 19:49
 * @version: 1.0
 */
@Service
public class ReadPropertiesServiceImpl implements ReadPropertiesService {

    @Value("${country}")
    private String country;

    @Value("${user.name}")
    private String name;


    @Value("${likes[0]}")
    private String game;

    @Value("${users[0].age}")
    private String age;

    @Value("${center.tmpDir}")
    private String list;

    @Value("${center.dir}")
    private String dir;

    /***
     * 使用自动装配将所有的数据封装到一个对象Environment中
     */
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Override
    public String Read() {
        String str = country +
                "\n" +
                name +
                "\n" +
                game +
                "\n" +
                age +
                "\n" +
                list +
                "\n" +
                dir +
                "\n";

        return str;
    }

    @Override
    public String ReadEnvironment() {
        String str = env.getProperty("users[0].age") +
                "\t" +
                String.valueOf(env.getDefaultProfiles());


        return str;
    }

    @Override
    public String ReadDataSource() {
        return dataSource.toString();
    }
}
