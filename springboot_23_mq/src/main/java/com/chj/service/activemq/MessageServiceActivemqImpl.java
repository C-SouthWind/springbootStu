package com.chj.service.activemq;

import com.chj.service.MessageService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.activemq
 * @className: MessageServiceActivemqImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/16 20:03
 * @version: 1.0
 */
@Service
public class MessageServiceActivemqImpl implements MessageService {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(String id) {
        System.out.println("消息id已存入" + id);
        jmsMessagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String doMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("消息已完成" + id);
        return id;
    }
}
