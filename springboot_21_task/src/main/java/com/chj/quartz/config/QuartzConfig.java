package com.chj.quartz.config;

import com.chj.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.quartz.config
 * @className: QuartzConfig
 * @author: chj
 * @description:
 * @date: Created in  2023/5/9 20:23
 * @version: 1.0
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        //绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).requestRecovery().storeDurably(true).build();
    }

    @Bean
    public Trigger trigger() {
        //绑定对应的工作明细   0秒  0分  0时  0日 0月 0星期
        ScheduleBuilder ScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail()).withSchedule(ScheduleBuilder).build();
    }

}




















































