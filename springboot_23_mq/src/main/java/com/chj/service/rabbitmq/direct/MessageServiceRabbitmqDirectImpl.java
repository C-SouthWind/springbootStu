package com.chj.service.rabbitmq.direct;

import com.chj.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rabbitmq.direct
 * @className: MessageServiceRabbitmqDirectImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/17 19:34
 * @version: 1.0
 */
@Service
public class MessageServiceRabbitmqDirectImpl implements MessageService {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("消息id已存入" + id);
        amqpTemplate.convertAndSend("direct_exchange", "direct", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
