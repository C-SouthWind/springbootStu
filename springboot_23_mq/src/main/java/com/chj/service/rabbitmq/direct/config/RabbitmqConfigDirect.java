package com.chj.service.rabbitmq.direct.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.rabbitmq.direct.config
 * @className: RabbitmqConfigDirect
 * @author: chj
 * @description:
 * @date: Created in  2023/5/17 19:38
 * @version: 1.0
 */
@Configuration
public class RabbitmqConfigDirect {

    @Bean  //消息队列
    public Queue directQueue() {
        return new Queue("direct_queue");
    }

    @Bean  //消息队列
    public Queue directQueue2() {
        return new Queue("direct_queue2");
    }

    @Bean  //直连交换机
    public DirectExchange directExchange() {
        return new DirectExchange("direct_exchange");
    }

    @Bean //绑定
    public Binding bindingDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }

    @Bean //绑定
    public Binding bindingDirect2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct2");
    }
}
