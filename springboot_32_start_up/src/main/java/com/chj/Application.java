package com.chj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: Springboot0103QuickstartApplication
 * @author: chj
 * @description:
 * @date: Created in  2023/2/14 20:19
 * @version: 1.0
 */


/**
 * 1、初始化各种属性，加载对象
 * - 读取环境属性（Environment）
 * - 系统配置（spring.factories）
 * - 参数（Arguments、application.properties）
 * 2、创建Spring容器对象ApplicationContext,加载各种配置
 * 3、在容器创建前，通过监听器机制，应对不同阶段加载数据、更新数据的需求
 * 4、容器初始化过程中追加各种功能，例如统计时间、输出日志等
 * <p>
 * <p>
 * <p>
 * 监听器类型
 * 1、在应用运行但未进行任何处理时，将发送 ApplicationStartingEvent
 * 2、当Environment被使用，且上下文创建前，将发送ApplicationEnvironmentPrepareEvent
 * 3、在开始刷新之前，bean定义被加载之后发送ApplicationPreparedEvent
 * 4、在上下文刷新之后且所有的应用和命令运行器被调用之前发送ApplicationStartedEvent
 * 5、在应用程序和命令行运行器被调用之后，将发出ApplicationReadyEvent，用于通知应用已经准备处理请求
 * 6、启动时发生异常，将发送ApplicationFailedEvent
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
































