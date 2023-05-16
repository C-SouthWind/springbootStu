package com.chj.service.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.activemq.listener
 * @className: MessageListener
 * @author: chj
 * @description:
 * @date: Created in  2023/5/16 20:15
 * @version: 1.0
 */
@Component
public class MessageListener {

    //监听消息  生产即消费
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")//转发到下一个消息  当前返回值生产到下一个消息  消息链
    public String receive(String id) {
        System.out.println("消息已完成" + id);
        return "new" + id;
    }
}
