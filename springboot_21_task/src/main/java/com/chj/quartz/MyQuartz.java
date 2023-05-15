package com.chj.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @projectName: springbootStu
 * @package: com.chj.quartz
 * @className: MyQuartz
 * @author: chj
 * @description:
 * @date: Created in  2023/5/9 20:21
 * @version: 1.0
 */
public class MyQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz task run...");
    }
}
