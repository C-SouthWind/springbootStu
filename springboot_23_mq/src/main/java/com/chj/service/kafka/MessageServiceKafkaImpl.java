package com.chj.service.kafka;

import com.chj.service.MessageService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.kafka
 * @className: MessageServiceKafkaImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/18 20:23
 * @version: 1.0
 */
@Service
public class MessageServiceKafkaImpl implements MessageService {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("消息id已存入" + id);
        kafkaTemplate.send("kafka_topic", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
