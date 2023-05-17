package com.chj.service.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

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
    @RabbitListener(queues = "topic_queue")
    public String receive(String id) {
        System.out.println("消息已完成" + id);
        return "new" + id;
    }
}
