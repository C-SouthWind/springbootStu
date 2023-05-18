package com.chj.service.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.kafka.listener
 * @className: MessageListener
 * @author: chj
 * @description:
 * @date: Created in  2023/5/18 20:27
 * @version: 1.0
 */
@Component
public class MessageListener {

    @KafkaListener(topics = "kafka_topic")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("消息已完成" + consumerRecord.value());
    }
}
