package com.chj.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @projectName: springbootStu
 * @package: com.chj.listener
 * @className: MyListener
 * @author: chj
 * @description:
 * @date: Created in  2023/6/27 20:53
 * @version: 1.0
 */
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.getTimestamp());
        System.out.println(event.getClass());
        System.out.println(event.getSource());
        System.out.println("======================================");
    }

}


//写一个事件的泛型  只干预者一个事件
class MyListener1 implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println(event.getTimestamp());
        System.out.println(event.getClass());
        System.out.println(event.getSource());
        System.out.println("======================================");
    }
}
