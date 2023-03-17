package com.chj.entriy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @projectName: springboot
 * @package: com.chj.entriy
 * @className: DataSource
 * @author: chj
 * @description:
 *      1.定义数据模型封装yaml文件中对应的数据
 *      2。定义为spring管控的bean
 *      3.读取对应的前缀
 *
 * @date: Created in  2023/3/2 20:36
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "DataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
