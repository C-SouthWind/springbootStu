package com.chj.service.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rabbitmq.topic.config
 * @className: RabbitmqConfigtopic
 * @author: chj
 * @description:
 * @date: Created in  2023/5/17 19:38
 * @version: 1.0
 */
@Configuration
public class RabbitmqConfigTopic {

    @Bean  //消息队列
    public Queue topicQueue() {
        return new Queue("topic_queue");
    }

    @Bean  //消息队列
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    @Bean  //主题交换机
    public TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange");
    }

    @Bean //绑定
    public Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

    @Bean //绑定
    public Binding bindingTopic2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic2");
    }
}
