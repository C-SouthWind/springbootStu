package com.chj.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.properties
 * @className: IpProperties
 * @author: chj
 * @description:
 * @date: Created in  2023/6/26 19:47
 * @version: 1.0
 */
@Component("ipProperties")
@ConfigurationProperties("tools.ip")
public class IpProperties {

    /**
     * 日志显示周期
     */
    private Long cycle = 5L;

    /**
     * 是否周期内重置数据
     */
    private Boolean cycleReset = false;

    /**
     * 日志输出模式 detail:  simple:极简模式
     */
    private String model = LogModel.DETAIL.value;


    public enum LogModel {
        /**
         * 详细模式
         */
        DETAIL("detail"),
        /**
         * 极简模式
         */
        SIMPLE("simple");
        private String value;

        LogModel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public Boolean getCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(Boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}





























