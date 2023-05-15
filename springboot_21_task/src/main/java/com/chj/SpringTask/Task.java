package com.chj.SpringTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.SpringTask
 * @className: Task
 * @author: chj
 * @description:
 * @date: Created in  2023/5/15 19:21
 * @version: 1.0
 */
@Component
public class Task {

    @Scheduled(cron = "0/5 * * * * ?")
    public void prints() {
        System.out.println("spring task run... ");
    }
}
