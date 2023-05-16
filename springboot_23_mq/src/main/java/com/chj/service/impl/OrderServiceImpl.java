package com.chj.service.impl;

import com.chj.service.MessageService;
import com.chj.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.impl
 * @className: OrderServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/16 19:41
 * @version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private MessageService messageService;

    @Override
    public void order(String id) {
        System.out.println("订单处理开始...");
        messageService.sendMessage(id);
        System.out.println("订单处理结束");
        System.out.println("==========");
    }
}
