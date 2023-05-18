package com.chj.service.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rocketmq.listener
 * @className: MessageListener
 * @author: chj
 * @description:
 * @date: Created in  2023/5/18 20:01
 * @version: 1.0
 */
@Component
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("消息已完成" + s);
    }
}
