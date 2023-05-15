package com.chj.service.imp;

import com.chj.service.TimerTaskService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.imp
 * @className: TimerTask
 * @author: chj
 * @description:
 * @date: Created in  2023/5/9 20:07
 * @version: 1.0
 */
public class TimerTaskServiceImpl implements TimerTaskService {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer is running....");
            }
        };

        timer.schedule(task, 0, 2000);

    }
}








































