package com.chj.service.rocketmq;

import com.chj.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.auth.callback.Callback;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rocketmq
 * @className: MessageServiceRocketmqImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/18 19:55
 * @version: 1.0
 */
@Service
public class MessageServiceRocketmqImpl implements MessageService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("消息id已存入" + id);
//        rocketMQTemplate.convertAndSend("order_id",id);

        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败");
            }
        };
        rocketMQTemplate.asyncSend("order_id", id, callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
