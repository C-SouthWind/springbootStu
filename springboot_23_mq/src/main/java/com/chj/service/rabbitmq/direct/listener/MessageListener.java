package com.chj.service.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rabbitmq.direct.listener
 * @className: MessageListener
 * @author: chj
 * @description:
 * @date: Created in  2023/5/17 19:49
 * @version: 1.0
 */
@Configuration
public class MessageListener {
    //监听消息  生产即消费
    @RabbitListener(queues = "direct_queue")
    public String receive(String id) {
        System.out.println("消息已完成" + id);
        return "new" + id;
    }
}
